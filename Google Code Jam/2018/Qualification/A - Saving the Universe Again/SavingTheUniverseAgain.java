import java.util.Scanner;

//Accepted in competition for the Small and Large datasets
public class SavingTheUniverseAgain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = Integer.parseInt(sc.nextLine());

		for(int i=1; i<=t; i++){
			String[] in = sc.nextLine().split(" ");
			int d = Integer.parseInt(in[0]);
			char[] p = in[1].toCharArray();

			int n = p.length;
			int[] currentCharge = new int[n];
			int totalDamage = 0;
			int charge = 1;

			for(int j=0; j<n; j++){
				if(p[j] == 'C'){
					charge = charge*2;
					currentCharge[j] = charge;
				}else{
					totalDamage += charge;
				}
			}

			int totalReduction = 0;
			int changes = 0;

			if(totalDamage > d){
				int j = n-1;
				while(j >= 1){
					if(p[j-1] == 'C' && p[j] == 'S'){
						char tempChar = p[j-1];
						p[j-1] = p[j];
						p[j] = tempChar;

						int tempInt = currentCharge[j-1];
						currentCharge[j-1] = currentCharge[j];
						currentCharge[j] = tempInt;

						totalReduction += currentCharge[j] / 2;
						changes++;

						if(totalDamage - totalReduction <= d){
							break;
						} else {
							j = n-1;
						}
					}else{
						j--;
					}
				}
			}

			System.out.print("Case #" + i + ": ");

			if(totalDamage - totalReduction <= d){
				System.out.println(changes);
			}else{
				System.out.println("IMPOSSIBLE");
			}
		}

		sc.close();
	}

}
