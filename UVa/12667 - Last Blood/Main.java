import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int t = Integer.parseInt(s[1]);
		int m = Integer.parseInt(s[2]);

		boolean submissions[][] = new boolean[n][t];

		int lastTeam[] = new int[n];
		int lastTime[] = new int[n];

		for(int i=0; i<n; i++){
			lastTeam[i] = -1;
			lastTime[i] = -1;
		}

		for(int i=0; i<m; i++){
			s = br.readLine().split(" ");
			int time = Integer.parseInt(s[0]);
			int teamID = Integer.parseInt(s[1]) - 1;
			int problem = s[2].charAt(0) - 'A';
			String veredict = s[3];
			if(veredict.equals("Yes") && problem < n && !submissions[problem][teamID]){
				lastTeam[problem] = teamID;
				lastTime[problem] = time;
				submissions[problem][teamID] = true;
			}
		}

		for(int i=0; i<n; i++){
			char problem = (char)(i + 'A');
			if(lastTime[i] == -1){
				System.out.println(problem + " - -");
			}else{
				System.out.println(problem + " " + lastTime[i] + " " + (lastTeam[i]+1));
			}
		}

	}

}
