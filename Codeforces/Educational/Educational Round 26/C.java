import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] l = br.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int a = Integer.parseInt(l[1]);
		int b = Integer.parseInt(l[2]);

		ArrayList<Seal> seals = new ArrayList<Seal>();
		for(int i=0; i<n; i++){
			l = br.readLine().split(" ");
			int x = Integer.parseInt(l[0]);
			int y = Integer.parseInt(l[1]);
			if((x <= a || x <= b) && (y <= a || y <= b)){
				seals.add(new Seal(x, y));
			}
		}

		int largestArea = 0;

		for(int i=0; i<seals.size(); i++){
			for(int j=i+1; j<seals.size(); j++){
				Seal S = seals.get(i);
				Seal T = seals.get(j);
				int currentArea = 0;

				// Case: One beside the other
				// S T
				if(S.x+T.x <= b && Integer.max(S.y, T.y) <= a){
					currentArea = S.x*S.y + T.x*T.y;
				}
				// S T'
				if(S.x+T.y <= b && Integer.max(S.y, T.x) <= a){
					currentArea = S.x*S.y + T.x*T.y;
				}
				// S' T
				if(S.y+T.x <= b && Integer.max(S.x, T.y) <= a){
					currentArea = S.x*S.y + T.x*T.y;
				}
				// S' T'
				if(S.y+T.y <= b && Integer.max(S.x, T.x) <= a){
					currentArea = S.x*S.y + T.x*T.y;
				}

				// Case: One on top of the other
				// S T
				if(S.x+T.x <= a && Integer.max(S.y, T.y) <= b){
					currentArea = S.x*S.y + T.x*T.y;
				}
				// S T'
				if(S.x+T.y <= a && Integer.max(S.y, T.x) <= b){
					currentArea = S.x*S.y + T.x*T.y;
				}
				// S' T
				if(S.y+T.x <= a && Integer.max(S.x, T.y) <= b){
					currentArea = S.x*S.y + T.x*T.y;
				}
				// S' T'
				if(S.y+T.y <= a && Integer.max(S.x, T.x) <= b){
					currentArea = S.x*S.y + T.x*T.y;
				}

				if(currentArea > largestArea){
					largestArea = currentArea;
				}
			}
		}

		System.out.println(largestArea);
	}
}

class Seal {
	public int x, y;
	public Seal(int x, int y){
		this.x = x;
		this.y = y;
	}
}
