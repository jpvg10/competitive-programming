import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Accepted in UVa
//Available at: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=5028
public class acis {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s;
		while((s = br.readLine()) != null){
			if(s.equals("*")) break;

			int n = Integer.parseInt(s);
			String[] l = br.readLine().split(" ");
			double xr = Double.parseDouble(l[0]);
			double yr = Double.parseDouble(l[1]);
			Point2D center = new Point2D.Double(xr, yr);

			Point2D[] vertices = new Point2D.Double[n];
			for(int i=0; i<n; i++){
				l = br.readLine().split(" ");
				double x = Double.parseDouble(l[0]);
				double y = Double.parseDouble(l[1]);
				vertices[i] = new Point2D.Double(x, y);
			}

			Line2D segment = new Line2D.Double(vertices[n-1], vertices[0]);
			double shortest = segment.ptSegDist(center);

			for(int i=0; i<n-1; i++){
				segment = new Line2D.Double(vertices[i], vertices[i+1]);
				double dist = segment.ptSegDist(center);
				if(dist < shortest){
					shortest = dist;
				}
			}

			System.out.format("%.3f\n", shortest);
		}
	}

}
