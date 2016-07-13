import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String l;
		while((l=br.readLine()) != null){
			int y = Integer.parseInt(l);
			int p = Integer.parseInt(br.readLine());

			int popes[] = new int[p];
			for(int i=0; i<p; i++)
				popes[i] = Integer.parseInt(br.readLine());

			int maximum[] = new int[p];
			for(int i=0; i<p; i++)
				maximum[i] = popes[i]+y-1;

			int best = 0;
			int first=0;
			int last=0;
			for(int i=0; i<p; i++){
				int index = binarySearchUpper(popes, maximum[i]);
				if(index-i+1>best){
					first = i;
					last = index;
					best = index-i+1;
				}
			}

			System.out.format("%d %d %d\n",best, popes[first], popes[last]);
			br.readLine();
		}
	}

	public static int binarySearchUpper(int v[], int i){
		int best = -1;
		int lo = 0;
		int hi = v.length-1;

		while(lo <= hi){
			int x = (lo+hi)/2;
			if(v[x] <= i){
				best = x;
				lo = x+1;
			}else{
				hi = x-1;
			}
		}

		return best;
	}
}
