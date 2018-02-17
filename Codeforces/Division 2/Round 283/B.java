import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		char l[] = sc.nextLine().toCharArray();
		int lock[] = new int[n];
		for(int i=0; i<n; i++){
			lock[i] = (int)l[i]-48;
		}

		int best[] = lock.clone();

		for(int i=0; i<n; i++){
			shift(lock);
			best = compare(lock, best);
			for(int j=0; j<10; j++){
				add1(lock);
				best = compare(lock, best);
			}
		}

		StringBuilder s = new StringBuilder();
		for(int i=0; i<n; i++){
			s.append(best[i]);
		}

		System.out.print(s.toString());
	}

	public static int[] compare(int lock[], int best[]){
		for(int i=0; i<lock.length; i++){
			if(lock[i] < best[i]){
				return lock.clone();
			}else if(lock[i] > best[i]){
				return best;
			}
		}
		return best;
	}

	public static void shift(int lock[]){
		int t = lock[0];
		int s = lock[0];
		lock[0] = lock[lock.length-1];
		for(int i=1; i<lock.length; i++){
			s = lock[i];
			lock[i] = t;
			t = s;
		}
	}

	public static void add1(int lock[]){
		for(int i=0; i<lock.length; i++){
			if(lock[i] == 9)
				lock[i] = 0;
			else
				lock[i]++;
		}
	}

}
