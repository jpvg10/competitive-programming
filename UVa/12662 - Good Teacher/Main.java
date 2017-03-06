import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int right[]=new int[n];
		int left[]=new int[n];
		Arrays.fill(right, -1);
		Arrays.fill(left, -1);

		String students[] = br.readLine().split(" ");

		int count = 0;
		boolean first = false;

		for(int i=0; i<students.length; i++){
			if(!students[i].equals("?")){
				first = true;
				right[i]=0;
				count = 0;
			}else if(first){
					count++;
					right[i] = count;
			}
		}

		count = 0;
		first = false;

		for(int i=students.length-1; i>=0; i--){
			if(!students[i].equals("?")){
				first = true;
				left[i] = 0;
				count = 0;
			}else if(first){
					count++;
					left[i] = count;
			}
		}

		int q = Integer.parseInt(br.readLine());

		for(int i=0; i<q; i++){
			int p = Integer.parseInt(br.readLine()) - 1;

			if(students[p].equals("?")){
				if((left[p] < right[p] && left[p] != -1) || right[p]==-1){
					StringBuilder sb = new StringBuilder();
					for(int k=0; k<left[p]; k++){
						sb.append("left of ");
					}
					sb.append(students[p+left[p]]);
					System.out.println(sb.toString());
				}else if((left[p] > right[p] && right[p] != -1) || left[p] == -1){
					StringBuilder sb = new StringBuilder();
					for(int k=0; k<right[p]; k++){
						sb.append("right of ");
					}
					sb.append(students[p-right[p]]);
					System.out.println(sb.toString());
				}else{
					String a = students[p-right[p]];
					String b = students[p+left[p]];
					System.out.println("middle of " + a + " and " + b);
				}
			}else{
				System.out.println(students[p]);
			}
		}
	}
}
