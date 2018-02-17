import java.util.ArrayList;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int i=0; i<t; i++){
			int n = sc.nextInt();

			ArrayList<Student> students = new ArrayList<Student>();

			for(int j=0; j<n; j++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				students.add(new Student(j, l, r));
			}

			int time = 1;

			for(int j=0; j<n; j++) {
				Student s = students.get(j);
				if(time < s.l) {
					System.out.print(s.l);
					time = s.l + 1;
				}else if(time >= s.l && time <= s.r) {
					System.out.print(time);
					time++;
				}else if(time > s.r) {
					System.out.print(0);
				}

				if(j < n-1) System.out.print(" ");
			}

			System.out.println();
		}

		sc.close();
	}

}

class Student {
	public int i,l, r;

	public Student(int i, int l, int r) {
		super();
		this.i = i;
		this.l = l;
		this.r = r;
	}
}
