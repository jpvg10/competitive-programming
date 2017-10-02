import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] elements;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean first = true;
		int k = 6;

		while(sc.hasNextInt()){
			int n = sc.nextInt();
			if(n == 0) break;
			if(!first) System.out.println();
			first = false;

			result = new int[k];
			elements = new int[n];
			for(int i=0; i<n; i++) {
				elements[i] = sc.nextInt();
			}
			Arrays.sort(elements);

			generateCombinations(k, 0);
		}

		sc.close();
	}

	public static void generateCombinations(int len, int startPosition){
		int n = elements.length;
		int k = result.length;
		if(len == 0){
			// Combination is complete
			processCombination();
		}else{
			for(int i=startPosition; i<=n-len; i++){
				result[k - len] = elements[i];
				generateCombinations(len-1, i+1);
			}
		}
	}

	public static void processCombination() {
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]);
			if(i < result.length-1) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}
