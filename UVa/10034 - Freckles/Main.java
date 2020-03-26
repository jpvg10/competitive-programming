import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine());

        for(int c=1; c<=cases; c++) {
            br.readLine();

            int n = Integer.parseInt(br.readLine());
            Point2D.Double[] points = new Point2D.Double[n];
            for(int i=0; i<n; i++) {
                String s[] = br.readLine().split(" ");
                points[i] = new Point2D.Double(Double.parseDouble(s[0]), Double.parseDouble(s[1]));
            }

            ArrayList<Edge> edges = new ArrayList<Edge>();

            for(int i=0; i<n; i++) {
                for(int j = i+1; j<n; j++) {
                    edges.add(new Edge(i, j, points[i].distance(points[j])));
                }
            }

            System.out.format(Locale.US, "%.2f\n", mst(edges, n));
            if(c < cases) System.out.print("\n");
        }
    }

    public static double mst(ArrayList<Edge> edges, int n)  {
        Collections.sort(edges);

        UnionFind uf = new UnionFind(n);
        double mstCost = 0;
        int i = 0;
        while(uf.getComponents() != 1){
            Edge e = edges.get(i);
            if(!uf.connected(e.u, e.v)){
                uf.union(e.u, e.v);
                mstCost += e.cost;
            }
            i++;
        }

        return mstCost;
    }

}


class Edge implements Comparable<Edge> {
    int u, v;
    double cost;
    static double e = 1e-6;

    public Edge(int u, int v, double cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }

    public int compareTo(Edge o) {
        if(Math.abs(this.cost - o.cost) < e) {
            return 0;
        } else if(this.cost > o.cost) {
            return 1;
        } else {
            return -1;
        }
    }
}

class UnionFind{
    private int[] parent, size;
    private int components;

    public UnionFind(int n){
        components = n;
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int root(int p){
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q){
        int rootP = root(p);
        int rootQ = root(q);
        if(rootP != rootQ){
            if(size[rootP] < size[rootQ]){
                parent[rootP] = rootQ;
                size[rootQ] = size[rootQ] + size[rootP];
            }else{
                parent[rootQ] = rootP;
                size[rootP] = size[rootP] + size[rootQ];
            }
            components--;
        }
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public int getComponents(){
        return components;
    }
}
