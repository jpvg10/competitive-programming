import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

//Accepted in Competition
//Available at: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=5182
public class soccer {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String l;
		while((l = br.readLine()) != null){
			int m = Integer.parseInt(l);
			Match[] matches = new Match[m];
			HashSet<String> teamNames = new HashSet<String>();

			for(int i=0; i<m; i++){
				String[] match = br.readLine().split("vs.");

				StringBuilder sb = new StringBuilder();
				int k = match[0].length() - 2;
				while(Character.isDigit(match[0].charAt(k))){
					sb.append(match[0].charAt(k));
					k--;
				}
				String teamA = match[0].substring(0, k);
				teamNames.add(teamA);
				int goalsA = Integer.parseInt(sb.reverse().toString());

				sb = new StringBuilder();
				k = 1;
				while(Character.isDigit(match[1].charAt(k))){
					sb.append(match[1].charAt(k));
					k++;
				}
				String teamB = match[1].substring(k+1, match[1].length());
				teamNames.add(teamB);
				int goalsB = Integer.parseInt(sb.toString());

				matches[i] = new Match(teamA, goalsA, teamB, goalsB);
			}

			HashMap<String, Team> teams = new HashMap<String, Team>();
			for(String s : teamNames){
				teams.put(s, new Team(s));
			}

			for(int i=0; i<m; i++){
				Match current = matches[i];
				Team tA = teams.get(current.teamA);
				Team tB = teams.get(current.teamB);
				if(current.goalsA == current.goalsB){
					tA.points += 1;
					tB.points += 1;
				}else if(current.goalsA < current.goalsB){
					tB.points += 3;
				}else{
					tA.points += 3;
				}
				tA.goalDif += (current.goalsA - current.goalsB);
				tB.goalDif += (current.goalsB - current.goalsA);
				tA.goals += current.goalsA;
				tB.goals += current.goalsB;
				tB.goalsVis += current.goalsB;

				teams.put(current.teamA, tA);
				teams.put(current.teamB, tB);
			}

			Team[] table = new Team[teams.size()];
			int j = 0;
			for(Entry<String, Team> e : teams.entrySet()){
				table[j] = e.getValue();
				j++;
			}
			Arrays.sort(table); // Positions end up in reverse order

			HashMap<String, Integer> reversePos = new HashMap<String, Integer>();
			for(int i=0; i<table.length; i++){
				reversePos.put(table[i].name, i);
			}

			int paradox = 0;
			for(int i=0; i<m; i++){
				Match current = matches[i];
				int posA = reversePos.get(current.teamA);
				int posB = reversePos.get(current.teamB);
				if(current.goalsA < current.goalsB && posA > posB){
					paradox++;
				}else if(current.goalsA > current.goalsB && posA < posB){
					paradox++;
				}
			}

			bw.write("The paradox occurs " + paradox + " time(s).\n");
			for(int i=table.length-1; i>=0; i--){
				int pos = table.length - i;
				bw.write(pos + ". " + table[i].name + "\n");
			}
		}

		bw.flush();
	}
}

class Team implements Comparable<Team> {
	public String name;
	public int points, goalDif, goals, goalsVis;

	@Override
	public int compareTo(Team o) {
		if(this.points != o.points){
			return this.points - o.points;
		}else if(this.goalDif != o.goalDif){
			return this.goalDif - o.goalDif;
		}else if(this.goals != o.goals){
			return this.goals - o.goals;
		}else if(this.goalsVis != o.goalsVis){
			return this.goalsVis - o.goalsVis;
		}else{
			return (-1)*(this.name.compareTo(o.name));
		}
	}

	public Team(String name){
		this.name = name;
		this.points = 0;
		this.goalDif = 0;
		this.goals = 0;
		this.goalsVis = 0;
	}
}

class Match {
	public String teamA, teamB;
	public int goalsA, goalsB;

	public Match(String teamA, int goalsA, String teamB, int goalsB){
		this.teamA = teamA;
		this.goalsA = goalsA;
		this.teamB = teamB;
		this.goalsB = goalsB;
	}
}
