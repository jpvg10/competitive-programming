import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);

		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		map.put('b', 0);
		map.put('g', 1);
		map.put('o', 2);
		map.put('r', 3);
		map.put('y', 4);

		while(sc.hasNextLine()){
			String l = sc.nextLine();
			if(l.charAt(0) == '#') break;

			ArrayList<char[]> cities = new ArrayList<char[]>();

			while(l.charAt(0) != 'e'){
				String[] line = l.split(",");
				char[] city = new char[5];

				for(int i=0; i<5; i++){
					char color = line[i].charAt(0);
					char waste = line[i].charAt(2);
					city[map.get(color)] = waste;
				}
				cities.add(city);

				l = sc.nextLine();
			}

			int model = findModel(cities);
			System.out.println(model);
		}

		sc.close();
	}

	public static int findModel(ArrayList<char[]> cities){
		int n = cities.size();

		int model = 0;
		int minimum = Integer.MAX_VALUE;

		for(int i=0; i<n; i++){
			int changes = 0;
			char base[] = cities.get(i);
			for(int j=0; j<n; j++){
				if(j != i){
					char[] current = cities.get(j);
					changes += compare(base, current);
				}
			}
			if(changes < minimum){
				minimum = changes;
				model = i+1;
			}
		}

		return model;
	}

	public static int compare(char[] city1, char[] city2){
		int dif=0;
		for(int i=0; i<city1.length; i++){
			if(city1[i] != city2[i]){
				dif++;
			}
		}
		return dif;
	}
}