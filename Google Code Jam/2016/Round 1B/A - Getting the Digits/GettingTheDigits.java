import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

//Accepted in competition for the Small and Large datasets
public class GettingTheDigits {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=t; i++){
			String s = br.readLine();
			
			LinkedList<Character> number = new LinkedList<Character>();
			
			int n = s.length();
			for(int j=0; j<n; j++){
				number.add(s.charAt(j));
			}
					
			Collections.sort(number);
			
			ArrayList<Integer> phoneNumber = new ArrayList<Integer>();
						
			while(Collections.binarySearch(number, 'Z') >= 0){
				int d;
				d = Collections.binarySearch(number, 'Z');
				number.remove(d);
				d = Collections.binarySearch(number, 'E');
				number.remove(d);
				d = Collections.binarySearch(number, 'R');
				number.remove(d);
				d = Collections.binarySearch(number, 'O');
				number.remove(d);					
				phoneNumber.add(0);
			}
			while(Collections.binarySearch(number, 'W') >= 0){
				int d;
				d = Collections.binarySearch(number, 'T');
				number.remove(d);
				d = Collections.binarySearch(number, 'W');
				number.remove(d);
				d = Collections.binarySearch(number, 'O');
				number.remove(d);					
				phoneNumber.add(2);
			}
			while(Collections.binarySearch(number, 'U') >= 0){
				int d;
				d = Collections.binarySearch(number, 'F');
				number.remove(d);
				d = Collections.binarySearch(number, 'O');
				number.remove(d);
				d = Collections.binarySearch(number, 'U');
				number.remove(d);
				d = Collections.binarySearch(number, 'R');
				number.remove(d);
				phoneNumber.add(4);
			}
			while(Collections.binarySearch(number, 'X') >= 0){
				int d;
				d = Collections.binarySearch(number, 'S');
				number.remove(d);
				d = Collections.binarySearch(number, 'I');
				number.remove(d);
				d = Collections.binarySearch(number, 'X');
				number.remove(d);					
				phoneNumber.add(6);
			}
			while(Collections.binarySearch(number, 'G') >= 0){
				int d;
				d = Collections.binarySearch(number, 'E');
				number.remove(d);
				d = Collections.binarySearch(number, 'I');
				number.remove(d);
				d = Collections.binarySearch(number, 'G');
				number.remove(d);
				d = Collections.binarySearch(number, 'H');
				number.remove(d);
				d = Collections.binarySearch(number, 'T');
				number.remove(d);
				phoneNumber.add(8);
			}
			while(Collections.binarySearch(number, 'O') >= 0){
				int d;
				d = Collections.binarySearch(number, 'O');
				number.remove(d);
				d = Collections.binarySearch(number, 'N');
				number.remove(d);
				d = Collections.binarySearch(number, 'E');
				number.remove(d);					
				phoneNumber.add(1);
			}
			while(Collections.binarySearch(number, 'H') >= 0){
				int d;
				d = Collections.binarySearch(number, 'T');
				number.remove(d);
				d = Collections.binarySearch(number, 'H');
				number.remove(d);
				d = Collections.binarySearch(number, 'R');
				number.remove(d);
				d = Collections.binarySearch(number, 'E');
				number.remove(d);
				d = Collections.binarySearch(number, 'E');
				number.remove(d);
				phoneNumber.add(3);
			}
			while(Collections.binarySearch(number, 'F') >= 0){
				int d;
				d = Collections.binarySearch(number, 'F');
				number.remove(d);
				d = Collections.binarySearch(number, 'I');
				number.remove(d);
				d = Collections.binarySearch(number, 'V');
				number.remove(d);
				d = Collections.binarySearch(number, 'E');
				number.remove(d);				
				phoneNumber.add(5);
			}
			while(Collections.binarySearch(number, 'S') >= 0){
				int d;
				d = Collections.binarySearch(number, 'S');
				number.remove(d);
				d = Collections.binarySearch(number, 'E');
				number.remove(d);
				d = Collections.binarySearch(number, 'V');
				number.remove(d);
				d = Collections.binarySearch(number, 'E');
				number.remove(d);
				d = Collections.binarySearch(number, 'N');
				number.remove(d);
				phoneNumber.add(7);
			}
			//NINE
			int k = number.size();
			while(k > 0){
				k = k-4;
				phoneNumber.add(9);
			}
			
			Collections.sort(phoneNumber);
			
			System.out.print("Case #" + i + ": ");
			
			for(int p : phoneNumber){
				System.out.print(p);
			}
			
			System.out.println();
		}		
	}
}
