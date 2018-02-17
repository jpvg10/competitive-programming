import java.util.LinkedList;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String s[] = sc.nextLine().split(" ");
		int alturas[] = new int[n];
		for(int i=0; i<n; i++){
			alturas[i] = Integer.parseInt(s[i]);
		}

		int dificultad[] = new int[n-1];

		for(int i=1; i<n; i++){
			dificultad[i-1] = alturas[i] - alturas[i-1];
		}

		int maxNormal = 0;
		for(int i=0; i<n-1; i++){
			if(dificultad[i] > maxNormal){
				maxNormal = dificultad[i];
			}
		}

		LinkedList<Integer> removiendo = new LinkedList<Integer>();

		for(int i=1; i<n-1; i++){
			int actual = dificultad[i-1] + dificultad[i];
			if(actual > maxNormal){
				removiendo.add(actual);
			}else{
				removiendo.add(maxNormal);
			}
		}

		int min = removiendo.get(0);
		for(int i=0; i<removiendo.size(); i++){
			if(removiendo.get(i) < min){
				min=removiendo.get(i);
			}
		}

		System.out.println(min);
	}
}
