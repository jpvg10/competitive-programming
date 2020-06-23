#include <stdio.h>

int digitCounts[100001][10];

int main(void) {
	int n, a, q, l, r;
	int i, j;
	int present;

	for(i=0; i<10; i++) {
		digitCounts[0][i] = 0;
	}

	while (scanf("%d", &n) == 1) {
		for (i = 1; i <= n; i++) {
			scanf("%d", &a);
			for (j = 0; j < 10; j++) {
				digitCounts[i][j] = digitCounts[i-1][j];
			}
			digitCounts[i][a]++;
		}

		scanf("%d", &q);

		for (i = 0; i < q; i++) {
			scanf("%d %d", &l, &r);

			present = 0;

			for (j = 0; j < 10; j++) {
				if(digitCounts[r][j] - digitCounts[l-1][j] > 0) {
					/* Number j is present in the range l,r */
					present++;
				}
			}

			printf("%d\n", present);
		}
	}

	return 0;
}
