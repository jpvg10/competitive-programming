import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int y = Integer.parseInt(br.readLine());

		int day = 1;
		boolean leapOriginal = isLeap(y);
		boolean leapCurrent = leapOriginal;

		do{
			y++;
			leapCurrent = isLeap(y);
			if(leapCurrent){
				day += 2;
			}else{
				day++;
			}
			day = day%7;
		}while(day != 1 || leapOriginal != leapCurrent);

		System.out.println(y);
	}

	public static boolean isLeap(int y){
		if(y % 400 == 0){
			return true;
		}else if(y % 4 == 0 && y % 100 != 0){
			return true;
		}else{
			return false;
		}
	}
}
