import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Problema de la competencia 03 de la RPC 2017
public class Main {
	  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			long s = Long.parseLong(br.readLine());
			long resultado = ((s+1)*(s+1))-1;
			bw.write(resultado + "\n");
		}

		 bw.flush();
	}

}
