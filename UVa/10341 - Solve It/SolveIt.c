#include <stdio.h>
#include <math.h>

/* Al compilar poner el parametro -lm */

double f(double x);

int p, q, r, s, t, u;

int main(void) {	
	while(scanf("%d %d %d %d %d %d", &p, &q, &r, &s, &t, &u) != EOF){
		if(f(0)*f(1) <= 0){
			double a = 0;
			double b = 1;
			int i;
			double c;
			for(i=0; i<24; i++){
				c = (a+b)/2;
				if(f(a)*f(c) <= 0){
					b = c;
				}else{
					a = c;
				}
			}
			printf("%.4lf\n", c);
		}else{
			printf("No solution\n");
		}
	}
	return 0;
}

double f(double x){
	return p*exp(-x) + q*sin(x) + r*cos(x) + s*tan(x) + t*x*x + u;
}
