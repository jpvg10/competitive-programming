import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		while(sc.hasNextLine()){
			String[] l = sc.nextLine().split(" ");

			int t = Integer.parseInt(l[0]);
			int r = Integer.parseInt(l[1]);
			int h = Integer.parseInt(l[2]);

			int[] priceTravel = new int[t];
			int[] priceRestaurant = new int[r];
			int[] priceHotel = new int[h];

			int[][] travelRestaurant = new int[t][r];
			int[][] restaurantHotel = new int[r][h];
			int[][] hotelTravel = new int[h][t];

			for(int i=0; i<t; i++){
				l = sc.nextLine().split(" ");
				priceTravel[i] = Integer.parseInt(l[0]);
				for(int j=0; j<r; j++){
					travelRestaurant[i][j] = Integer.parseInt(l[j+1]);
				}
			}

			for(int i=0;i<r;i++){
				l=sc.nextLine().split(" ");
				priceRestaurant[i] = Integer.parseInt(l[0]);
				for(int j=0; j<h; j++){
					restaurantHotel[i][j] = Integer.parseInt(l[j+1]);
				}
			}

			for(int i=0; i<h; i++){
				l = sc.nextLine().split(" ");
				priceHotel[i] = Integer.parseInt(l[0]);
				for(int j=0; j<t; j++){
					hotelTravel[i][j] = Integer.parseInt(l[j+1]);
				}
			}

			int idealHotel=-1, idealRestaurant=-1, idealTravel=-1;
			int totalPrice = Integer.MAX_VALUE;

			for(int i=0; i<t; i++){
				for(int j=0; j<r; j++){
					if(travelRestaurant[i][j] == 0){
						for(int k=0; k<h; k++){
							int price = priceTravel[i] + priceRestaurant[j] + priceHotel[k];
							if(restaurantHotel[j][k] == 0 && hotelTravel[k][i] == 0 && price < totalPrice){
								idealHotel = k;
								idealRestaurant = j;
								idealTravel = i;
								totalPrice = price;
							}
						}
					}
				}
			}

			if(idealHotel==-1) {
				System.out.println("Don't get married!");
			}else {
				System.out.println(idealTravel + " " + idealRestaurant + " " + idealHotel + ":" + totalPrice);
			}
		}

		sc.close();
	}
}
