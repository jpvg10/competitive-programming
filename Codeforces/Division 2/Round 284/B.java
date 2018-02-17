import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s[] = sc.nextLine().split(" ");

		int palabrasProfesor = Integer.parseInt(s[0]);
		int palabrasLenguaje = Integer.parseInt(s[1]);

		Map<String, String> treeMap = new TreeMap<String, String>();

		for(int i=0; i<palabrasLenguaje; i++){
			String linea[] = sc.nextLine().split(" ");
			treeMap.put(linea[0], linea[1]);
		}

		String lecture[] = sc.nextLine().split(" ");
		StringBuilder salida = new StringBuilder();

		for(int j=0; j<palabrasProfesor; j++){
			String l1 = lecture[j];
			String l2 = treeMap.get(l1);
			if(l2.length() < l1.length()){
				salida.append(l2);
			}else{
				salida.append(l1);
			}
			if(j < palabrasProfesor-1){
				salida.append(" ");
			}
		}

		System.out.println(salida.toString());
	}

}
