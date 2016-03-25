import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static double e = 0.0000001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String l;
		while(!(l = br.readLine()).equals("0 0 0.0")){
			String s[] = l.split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			double w = Double.parseDouble(s[2]);
			
			s = br.readLine().split(" ");
			double width[] = new double[s.length];
			for(int i=0; i<x; i++)
				width[i] = Double.parseDouble(s[i]);
			
			s = br.readLine().split(" ");
			double height[] = new double[s.length];
			for(int i=0; i<y; i++)
				height[i] = Double.parseDouble(s[i]);
			
			Arrays.sort(width);
			Arrays.sort(height);
			
			if(width[0]-w/2 >= e){
				System.out.println("NO");
			}else if(75.0 - (width[x-1]+w/2) >= e){
				System.out.println("NO");
			}else if(height[0]-w/2 >= e){
				System.out.println("NO");
			}else if(100.0 - (height[y-1]+w/2) >= e){
				System.out.println("NO");
			}else{
				boolean ok = true;
				for(int i=1; i<x; i++){
					double c = width[i] - width[i-1];
					if(width[i]-width[i-1]-w >= e){
						System.out.println("NO");
						ok = false;
						break;
					}
				}
				if(ok){
					for(int i=1; i<y; i++){
						if(height[i]-height[i-1]-w >= e){
							System.out.println("NO");
							ok = false;
							break;
						}
					}
				}
				if(ok) System.out.println("YES");
			}
		}

	}

}
