import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String in[] = br.readLine().split(" ");
		int n = Integer.parseInt(in[0]);
		int a = Integer.parseInt(in[1]);
		int b = Integer.parseInt(in[2]);
		int p = Integer.parseInt(in[3]);
		int q = Integer.parseInt(in[4]);

		long red = n / a;
		long blue = n /b;

		long multiple = lcm(a, b);

		long both = n / multiple;

		if(p > q){
			blue = blue - both;
		}else{
			red = red - both;
		}

		long chocolate = red*p + blue*q;

		System.out.println(chocolate);
	}

	public static int gcd(int a, int b){
		while(b != 0){
			int t = b;
			b = a%b;
			a = t;
		}
		return a;
	}

	//Divide first to avoid overflow in a*b
	public static long lcm(int a, int b){
		return (long)a * (b / gcd(a, b));
	}

}
