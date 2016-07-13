import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean first = true;
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			StringBuilder sb = new StringBuilder();
			int len = line.length();
			for(int i=0; i<len; i++){
				char c = line.charAt(i);
				if(c != '"'){
					sb.append(c);
				}else if(first){
					sb.append("``");
					first = false;
				}else{
					sb.append("''");
					first = true;
				}
			}
			System.out.println(sb.toString());
		}
	}
}
