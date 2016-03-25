import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i=0; i<n; i++){
			String l[] = sc.nextLine().split(" ");
			String a = l[0];
			String b = l[1];
			add(a, b);
			if(i<n-1){
				System.out.println();
			}
		}
	}
	
	public static void add(String a, String b){
		if(a.length()!= b.length() && a.length()<32 && b.length()<32){
			if(a.length()>b.length()){
				StringBuilder z = new StringBuilder(b);
                z.reverse();
				while(z.length()<a.length()){					
					z.append(0);					
				}
                z.reverse();
				b = z.toString();
			}else{
				StringBuilder z = new StringBuilder(a);
				z.reverse();
                while(z.length()<b.length()){					
					z.append(0);					
				}
                z.reverse();
				a = z.toString();
			}
		}
		
		if(b.length()>31){
			b = "overflow";
		}
		if(a.length()>31){
			a = "overflow";
		}		
				
		boolean cero = true;
		int i = 0;
		while(i<b.length() && cero==true){
			if(b.charAt(i)!='0'){				
				cero = false;
			}	
			i++;
		}
		
		System.out.println(a + " " + b);
		
		if(!cero && !a.equals("overflow") && !b.equals("overflow")){			
			StringBuilder c = new StringBuilder();
			StringBuilder d = new StringBuilder();
			for(int j=0; j<a.length(); j++){
				if(a.charAt(j)!=b.charAt(j)){
					c.append(1);
				}else{
					c.append(0);
				}
				if(a.charAt(j)=='1' && b.charAt(j)=='1'){
					d.append(1);
				}else{
					d.append(0);
				}
			}
			a = c.toString();
			b = mult2Bin(d.toString());				
			add(a, b);				
		}					
	}
	
	public static String mult2Bin(String d){
		StringBuilder c = new StringBuilder(d);		
		if(d.charAt(0)=='0'){
			c.deleteCharAt(0);
			c.append(0);
		}else{
			c.append(0);
		}
		return c.toString();
	}
}
