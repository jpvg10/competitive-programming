import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

//Accepted for the small and large datasets in Practice Mode
public class AmpleSyrup {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int c=1; c<=t; c++){
			String[] l = br.readLine().split(" ");
			int n = Integer.parseInt(l[0]);
			int k = Integer.parseInt(l[1]);

			LinkedList<Pancake> sortedByRadius = new LinkedList<Pancake>();
			LinkedList<Pancake> sortedBySideArea = new LinkedList<Pancake>();

			for(int i=0; i<n; i++){
				l = br.readLine().split(" ");
				int r = Integer.parseInt(l[0]);
				int h = Integer.parseInt(l[1]);
				Pancake p = new Pancake(i, r, h);
				sortedByRadius.add(p);
				sortedBySideArea.add(p);
			}

			Collections.sort(sortedByRadius, new Comparator<Pancake>() {
			    public int compare(Pancake p1, Pancake p2) {
			        return p2.r - p1.r;
			    }
			});

			Collections.sort(sortedBySideArea, new Comparator<Pancake>() {
			    public int compare(Pancake p1, Pancake p2) {
			        if(p1.sideArea < p2.sideArea){
			        	return 1;
			        }else if(p1.sideArea == p2.sideArea){
			        	return 0;
			        }else{
			        	return -1;
			        }
			    }
			});

			double bestSolution = -1.0;
			Iterator<Pancake> itRadius = sortedByRadius.iterator();
			while(itRadius.hasNext()){
				Pancake base = itRadius.next();
				double solution = base.faceArea + base.sideArea;
				int count = 1;

				Iterator<Pancake> itArea = sortedBySideArea.iterator();
				while(itArea.hasNext() && count < k){
					Pancake current = itArea.next();
					if(current.r > base.r){
						itArea.remove();
					}else if(current.id != base.id){
						solution += current.sideArea;
						count++;
					}
				}

				if(solution > bestSolution){
					bestSolution = solution;
				}
			}

			System.out.format(Locale.US, "Case #%d: %.6f\n", c, bestSolution);
		}
	}
}

class Pancake {
	public int id, r, h;
	public double faceArea, sideArea;
	public Pancake(int id, int r, int h){
		this.id = id;
		this.r = r;
		this.h = h;
		this.faceArea = Math.PI * r * r;
		this.sideArea = 2 * Math.PI * r * h;
	}
}
