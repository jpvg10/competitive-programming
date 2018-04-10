import java.util.Scanner;

//Accepted in competition for the Small dataset
public class CubicUFO {

	public static double piHalfs = Math.PI / 2;
	public static double e = 1e-6;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = Integer.parseInt(sc.nextLine());

		for(int i=1; i<=t; i++){
			double a = Double.parseDouble(sc.nextLine());

			double lower = 0;
			double upper = Math.PI / 4;
			boolean found = false;
			double theta;

			do{
				theta = (lower + upper) / 2;
				double l = Math.cos(theta) + Math.cos(piHalfs - theta);

				if(Math.abs(a - l) <= e){
					found = true;
				}else if(a - l < 0){
					upper = theta;
				}else{
					lower = theta;
				}
			}while(!found);

			System.out.println("Case #" + i + ": ");

			Point3D faceCenter = new Point3D(0, 0, 0.5);
			System.out.println(Point3D.rotateZAxis(faceCenter, theta));
			faceCenter = new Point3D(0, 0.5, 0);
			System.out.println(Point3D.rotateZAxis(faceCenter, theta));
			faceCenter = new Point3D(0.5, 0, 0);
			System.out.println(Point3D.rotateZAxis(faceCenter, theta));
		}

		sc.close();
	}

}

class Point3D {
	double x, y, z;

	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static Point3D rotateZAxis(Point3D p, double theta){
		double xPrime = p.x*Math.cos(theta) - p.y*Math.sin(theta);
		double yPrime = p.x*Math.sin(theta) + p.y*Math.cos(theta);
		return new Point3D(xPrime, yPrime, p.z);
	}

	public String toString(){
		return this.x + " " + this.y + " " + this.z;
	}
}
