import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int solutionAttack;
	static int solutionDefense;
	static boolean[] solutionPlayers;
	static String[] solutionAttackerNames;
	static int[] result;
	static Player[] players;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());

		for(int i=1; i<=t; i++){
			solutionAttack = 0;
			solutionDefense = 0;
			result = new int[5];
			players = new Player[10];

			for(int j=0; j<10;j++){
				String[] l = sc.nextLine().split(" ");
				players[j] = new Player(l[0], Integer.parseInt(l[1]), Integer.parseInt(l[2]));
			}

			generateCombinations(5, 0);

			String[] solutionDefenderNames = new String[5];
			int d = 0;

			for(int j=0; j<10; j++){
				if(!solutionPlayers[j]) {
					solutionDefenderNames[d] = players[j].name;
					d++;
				}
			}

			Arrays.sort(solutionDefenderNames);

			System.out.print("Case " + i + ":\n(");

			for(int j=0; j<5; j++){
				System.out.print(solutionAttackerNames[j]);
				if(j<4) {
					System.out.print(", ");
				}
			}

			System.out.print(")\n(");

			for(int j=0; j<5; j++){
				System.out.print(solutionDefenderNames[j]);
				if(j<4) {
					System.out.print(", ");
				}
			}

			System.out.print(")\n");
		}

		sc.close();
	}

	public static void generateCombinations(int len, int startPosition){
		int n = players.length;
		int k = result.length;
		if(len == 0){
			// Combination is complete
			processCombination();
		}else{
			for(int i=startPosition; i<=n-len; i++){
				result[k - len] = i;
				generateCombinations(len-1, i+1);
			}
		}
	}

	public static void processCombination(){
		boolean[] isAttacker = new boolean[10];
		int attack = 0;
		int defense = 0;
		String[] attackerNames = new String[5];

		for(int i=0; i<5; i++) {
			isAttacker[result[i]] = true;
			attack += players[result[i]].attack;
			attackerNames[i] = players[result[i]].name;
		}

		Arrays.sort(attackerNames);

		for(int i=0; i<10; i++) {
			if(!isAttacker[i]) {
				defense += players[i].defense;
			}
		}

		if(attack > solutionAttack) {
			solutionAttack = attack;
			solutionDefense = defense;
			solutionPlayers = isAttacker;
			solutionAttackerNames = attackerNames;
		}else if(attack == solutionAttack) {
			if(defense > solutionDefense) {
				solutionAttack = attack;
				solutionDefense = defense;
				solutionPlayers = isAttacker;
				solutionAttackerNames = attackerNames;
			}else if(defense == solutionDefense) {
				boolean better = true;
				for(int i=0; i<5; i++) {
					if(attackerNames[i].compareTo(solutionAttackerNames[i]) > 0) {
						better = false;
						break;
					}
				}
				if(better) {
					solutionAttack = attack;
					solutionDefense = defense;
					solutionPlayers = isAttacker;
					solutionAttackerNames = attackerNames;
				}
			}
		}
	}
}

class Player{
	String name;
	int attack, defense;

	public Player(String name, int attack, int defense){
		this.name = name;
		this.attack = attack;
		this.defense = defense;
	}
}