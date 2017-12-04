#include <stdio.h>

int main(void) {
	int c;
	while(scanf("%c", &c) != EOF){
		if((char)c=='\n'){
			printf("\n");
		}else{
			printf("%c", c-7);
		}
	}
	return 0;
}
