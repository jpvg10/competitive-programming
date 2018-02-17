import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

//Important to use BufferedReader and BufferedWriter
public class C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		ArrayList<String> operations = new ArrayList<String>();

		for(int i=0; i<n; i++){
			String o = br.readLine();
			String op[] = o.split(" ");
			if(op[0].equals("insert")){
				heap.add(Integer.parseInt(op[1]));
				operations.add(o);
			}else if(op[0].equals("removeMin")){
				if(heap.isEmpty()){
					operations.add("insert 1");
				}else{
					heap.poll();
				}
				operations.add(o);
			}else if(op[0].equals("getMin")){
				int x = Integer.parseInt(op[1]);
				while(!heap.isEmpty() && heap.peek() < x){
					operations.add("removeMin");
					heap.poll();
				}
				if(heap.isEmpty() || heap.peek() > x){
					operations.add("insert " + x);
					heap.add(x);
				}
				operations.add(o);
			}
		}

		BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

		log.write(operations.size() + "\n");

		for(String o : operations){
			log.write(o + "\n");
		}

		log.close();
	}
}
