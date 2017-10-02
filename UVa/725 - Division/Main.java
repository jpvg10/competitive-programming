import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	static int[] digits;
	static boolean p[];
	static LinkedList<Integer> permutation;
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		digits = new int[10];
		p = new boolean[10];
		permutation = new LinkedList<Integer>();
		for(int i=0; i<=9; i++) {
			digits[i] = i;
		}

		generatePermutations();

		for(ArrayList<Integer> numerators : map.values()) {
			Collections.sort(numerators);
		}

		boolean first=true;

		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			if(n == 0) break;
			if(!first) System.out.println();
			first = false;

			if(map.containsKey(n)) {
				ArrayList<Integer> current = map.get(n);
				for(int a : current) {
					int b = a / n;
					System.out.format("%05d / %05d = %d\n", a, b, n);
				}
			}else {
				System.out.println("There are no solutions for " + n + ".");
			}
		}

		sc.close();
	}

	public static void generatePermutations() {
		int n = digits.length;
		if(permutation.size() == n) {
			// Permutation is complete
			processPermutation();
		}else {
			for(int i=0; i<n; i++) {
				if(!p[i]){
					p[i] = true;
					permutation.addLast(digits[i]);
					generatePermutations();
					p[i] = false;
					permutation.pollLast();
				}
			}
		}
	}

	public static void processPermutation() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<5; i++) {
			sb.append(permutation.get(i));
		}
		int a = Integer.parseInt(sb.toString());

		sb = new StringBuilder();
		for(int i=5; i<10; i++) {
			sb.append(permutation.get(i));
		}
		int b = Integer.parseInt(sb.toString());

		if(a%b == 0) {
			int n = a/b;
			if(!map.containsKey(n)) {
				map.put(n, new ArrayList<Integer>());
			}
			map.get(n).add(a);
		}
	}
}