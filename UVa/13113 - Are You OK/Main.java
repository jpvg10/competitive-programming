import java.awt.Polygon;
import java.awt.geom.Line2D;
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
            
            Polygon p = new Polygon();
            Line2D lines[] = new Line2D.Double[a];
            
            int lx = 0;
            int ly = 0;
            
            int fx = 0;
            int fy = 0;
            
            for(int j=0; j<a; j++){
                l = br.readLine().split(" ");
                int x = Integer.parseInt(l[0]);
                int y = Integer.parseInt(l[1]);
                if(j == 0){
                    fx = x;
                    fy = y;
                }
                
                if(j>=1 && j < a){
                    lines[j] = new Line2D.Double(x, y, lx, ly);
                }  
                
                p.addPoint(x, y);                
                lx = x;
                ly = y;
            }

            lines[0] = new Line2D.Double(fx, fy, lx, ly);
            
            int count = 0;
            
            for(int j=0; j<b; j++){
                l = br.readLine().split(" ");
                int x = Integer.parseInt(l[0]);
                int y = Integer.parseInt(l[1]);
                boolean inBorder = false;
                for(int k = 0; k < a; k++){
                    inBorder = pointInLine(x,y, lines[k]);
                    if(inBorder)
                        break;
                    
                }
                if(p.contains(x, y) && !inBorder) count++;         
            }
            System.out.println(count);
        }
    }

    private static boolean pointInLine(int x, int y, Line2D line) {
        double x0 = line.getX1();
        double x1 = line.getX2();
        double y0 = line.getY1();
        double y1 = line.getY2();
        
        double xizq = x0<x1?x0:x1;
        double xder  = x0<x1?x1:x0;
        double yup = y0<y1?y1:y0;
        double ydown = y0>y1?y1:y0;
        
        if(x >= xizq && x<= xder && y >= ydown && y <= yup){
            return x*(y0-y1)+y*(x1-x0)+x0*y1-y0*x1 == 0;
        }else{
            return false;
        }
        
    }
}
