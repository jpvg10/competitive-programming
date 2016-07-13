import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Problema de la competencia 05 de la RPC 2016
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int i=0; i<t; i++){
			String l[] = br.readLine().split(" ");
			int a = Integer.parseInt(l[0]);
			int b = Integer.parseInt(l[1]);

			long votes[] = new long[a];
			long sum = 0;

			for(int j=0; j<b; j++){
				l = br.readLine().split(" ");
				long v = Long.parseLong(l[a]);
				sum += v;
				for(int k=0; k<a; k++){
					double por = Double.parseDouble(l[k]) * 1000;
					votes[k] += (long)(v*por);
				}
			}

			for(int k=0; k<a; k++){
				votes[k] = votes[k] / 100000;
			}

			double porcentaje[] = new double[a];
			int primero = -1, segundo = -1;
			long votosPrimero = -1, votosSegundo = -1;

			for(int k=0; k<a; k++){
				porcentaje[k] = (double) (votes[k]*100) / (double) sum;
				if(votes[k] > votosPrimero){
					votosSegundo = votosPrimero;
					segundo = primero;
					votosPrimero = votes[k];
					primero = k;
				}else if(votes[k] > votosSegundo){
					votosSegundo = votes[k];
					segundo = k;
				}
			}

			if(porcentaje[primero] >= 50.1){
				System.out.println((primero+1) + " " + votosPrimero);
			}else{
				System.out.println((primero+1) + " " + votosPrimero);
				System.out.println((segundo+1) + " " + votosSegundo);
			}

			if(i<t-1) System.out.println();
		}
	}
}
