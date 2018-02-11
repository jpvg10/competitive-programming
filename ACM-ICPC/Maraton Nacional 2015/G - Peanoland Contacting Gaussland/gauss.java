import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Accepted in competition
//Available at: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=4825
public class gauss {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s;	
		while((s = br.readLine()) != null){
			int p = Integer.parseInt(s);
			int b = p;
			int k = 0;
			int ans[] = new int[2];
			while(b != 0){
				int r = b % 2;
				if(r == 1){
					int t[] = complexPower(k);
					ans[0] += t[0];
					ans[1] += t[1];
				}
				k++;
				b = b/2;
			}
			bw.write(ans[0] + " " + ans[1] + "\n");
		}
		bw.flush();
	}
	
	//Finds the result of (i-1)^k = a[0]+a[1]*i
	public static int[] complexPower(int k){
		int grupo = k/4;
		int index = k%4;
		int signo;
		if(grupo % 2 == 0){
			signo = 1;
		}else{
			signo = -1;
		}
		int ans[] = new int[2];
		int coef = (int)Math.pow(2, k/2);
		switch(index){
			case 0:
				ans[0] = 1*signo*coef;
				ans[1] = 0;
				break;
			case 1:
				ans[0] = -1*signo*coef;
				ans[1] = 1*signo*coef;
				break;
			case 2:
				ans[0] = 0;
				ans[1] = -1*signo*coef;
				break;
			case 3:
				ans[0] = 1*signo*coef;
				ans[1] = 1*signo*coef;
				break;
		}
		return ans;
	}
}
