import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

//Problema de la competencia 03 de la RPC 2017
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String entrada[] = br.readLine().split(" ");
			int n = Integer.parseInt(entrada[0]);
			int k = Integer.parseInt(entrada[1]);
			int prioridad = 1;

			PriorityQueue<Medicina> medicinas = new PriorityQueue<Medicina>();
			for (int j = 0; j < n; j++) {
				entrada = br.readLine().split(" ");
				String nombre = entrada[0];
				int frecuencia = Integer.parseInt(entrada[1]);
				Medicina x = new Medicina(nombre, frecuencia, prioridad);
				medicinas.add(x);
				prioridad++;
			}

			for (int j = 0; j < k; j++) {
				Medicina actual = medicinas.poll();
				bw.write(actual.valorActual + " " + actual.nombre + "\n");
				actual.valorActual += actual.frecuencia;
				medicinas.add(actual);
			}
		}

		bw.flush();
	}
}

class Medicina implements Comparable<Medicina> {
	String nombre;
	int frecuencia;
	int valorActual;
	int prioridad;

	public Medicina(String nombre, int frecuencia, int prioridad) {
		this.nombre = nombre;
		this.valorActual = frecuencia;
		this.frecuencia = frecuencia;
		this.prioridad = prioridad;
	}

	public int compareTo(Medicina o) {
		if (this.valorActual == o.valorActual) {
			return this.prioridad - o.prioridad;
		} else {
			return this.valorActual - o.valorActual;
		}
	}
}