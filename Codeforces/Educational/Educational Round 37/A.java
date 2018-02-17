import java.util.Scanner;

public class A
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int i=0; i<t; i++){
			int n = sc.nextInt();
			int k = sc.nextInt();

			int pos = 0;
			int prevTap = Integer.MIN_VALUE + 1;
			int maxDist = Integer.MIN_VALUE + 1;

			for(int j=0; j<k; j++){
				int tap = sc.nextInt() - 1;
				while(pos <= tap){
					int closest = Integer.min(tap-pos, pos-prevTap);
					maxDist = Integer.max(maxDist, closest);
					pos++;
				}
				prevTap = tap;
			}

			while(pos < n){
				int closest = pos-prevTap;
				maxDist = Integer.max(maxDist, closest);
				pos++;
			}

			System.out.println(maxDist + 1);

			sc.close();
		}
	}
}
