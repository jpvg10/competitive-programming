import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		String[] names = {"Danil", "Olya", "Slava", "Ann", "Nikita"};

		Scanner sc = new Scanner(System.in);

		String problem = sc.nextLine();

		int found = 0;

		for(int i=0; i<names.length; i++) {
			int index = KMP(problem, names[i], 0);
			if(index != -1) {
				found++;
				int secondIndex = KMP(problem, names[i], index+names[i].length());
				if(secondIndex != -1) {
					found++;
				}
			}
			if(found > 1) {
				break;
			}
		}

		if(found == 1) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}

		sc.close();
	}

	private static int[] computeTemporaryArray(String pattern){
		int lps[] = new int[pattern.length()];
		int index = 0;
		int i = 1;
		while(i < pattern.length()){
			if(pattern.charAt(i) == pattern.charAt(index)){
				lps[i] = index + 1;
				index++;
				i++;
			}else{
				if(index != 0){
					index = lps[index-1];
				}else{
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

	public static int KMP(String text, String pattern, int start){
		int lps[] = computeTemporaryArray(pattern);
		int i = start;
		int j = 0;
		while(i < text.length() && j < pattern.length()){
			if(text.charAt(i) == pattern.charAt(j)){
				i++;
				j++;
			}else{
				if(j!=0){
					j = lps[j-1];
				}else{
					i++;
				}
			}
		}
		if(j == pattern.length()){
			return i-j;
		}
		return -1;
	}

}
