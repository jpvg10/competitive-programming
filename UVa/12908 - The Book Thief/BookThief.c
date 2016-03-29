#include <stdio.h>
#include <math.h>

//Problema de la competencia 05 de la RPC 2015
int main(void)
{
	int s;
	scanf("%d", &s);
	while(s != 0){		
		double n = (-1 + sqrt(1+8*s))/2;
		double m = ceil(n);
		int k = (int)m;
		if(n == m){			
			printf("%d %d\n", k+1, k+1);
		}else{
			int r = k*(k+1)/2;
			printf("%d %d\n", r-s, k);
		}
		scanf("%d", &s);
	}
	
	return 0;	
}
