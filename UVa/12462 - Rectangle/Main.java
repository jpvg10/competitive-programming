import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String l;
		while((l = br.readLine()) != null) {
			if(l.equals("0 0")) break;
			String[] line = l.split(" ");

			int n = Integer.parseInt(line[0]);
			int c = Integer.parseInt(line[1]);

			long[] height = new long[n];
			int[] color = new int[n];

			line = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				height[i] = Long.parseLong(line[i]);
			}

			line = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				color[i] = Integer.parseInt(line[i]);
			}

			int[] end = calculateEnd(color, c);
			int i = 0;
			long area = 0;
			long maxArea = 0;
			Stack<Integer> st = new Stack<Integer>();

			while(i < n){
	            if(st.isEmpty() || height[st.peek()] <= height[i]){
	                st.push(i);
	                i++;
	            }else{
	                int top = st.pop();
					if(st.isEmpty()){
						if(end[0] != -1 && end[0] <= i-1) {
							area = height[top] * i;
							maxArea = Long.max(area, maxArea);
						}
	                }else {
	                	if(end[st.peek() + 1] != -1 && end[st.peek() + 1] <= i-1) {
	                		area = height[top] * (i - st.peek() - 1);
	                		maxArea = Long.max(area, maxArea);
	                	}
	                }
	            }
	        }

	        while(!st.isEmpty()){
	            int top = st.pop();
	            if(st.isEmpty()){
					if(end[0] != -1 && end[0] <= i-1) {
						area = height[top] * i;
						maxArea = Long.max(area, maxArea);
					}
				}else {
					if(end[st.peek() + 1] != -1 && end[st.peek() + 1] <= i-1) {
						area = height[top] * (i - st.peek() - 1);
						maxArea = Long.max(area, maxArea);
					}
				}
	        }

	        System.out.println(maxArea);
		}

	}

	public static int[] calculateEnd(int[] color, int c) {
		int n = color.length;
		int[] end = new int[n];
		Arrays.fill(end, -1);
		HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();

		int j = -1;
		int i = 0;

		while(i < n) {
			while(j < n-1 && counter.size() < c) {
				j++;
				int colJ = color[j];
				if(counter.containsKey(colJ)) {
					counter.put(colJ, counter.get(colJ) + 1);
				}else {
					counter.put(colJ, 1);
				}
			}
			if(counter.size() == c) {
				end[i] = j;
				int colI = color[i];
				if(counter.get(colI) == 1) {
					counter.remove(colI);
				}else {
					counter.put(colI, counter.get(colI) - 1);
				}
				i++;
			}else {
				break;
			}
		}

		return end;
	}

}
