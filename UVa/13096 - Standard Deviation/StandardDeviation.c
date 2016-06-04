#include <stdio.h>
#include <math.h>

/*
Problema de la competencia 03 de la RPC 2016
Al compilar incluir el parámetro -lm
*/

int main(void){
	long n;
	
	while(scanf("%ld", &n) != EOF){
		if(n == 0) break;
		double s = sqrt(n*(n+1)/3.0);
		printf("%.6f\n", s);
	}
	
	return 0;
}
