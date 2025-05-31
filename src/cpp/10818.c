#include <stdio.h>
#include <stdlib.h>

int compare(const void * a, const void * b) {
    return(*(int*)b-*(int*)a);
}

int main(void) {
    int n;
    scanf("%d", &n);
    int input[n];
    for(int i=0; i<n; i++) {
        scanf("%d", &input[i]);
    }
    qsort(input, n, 4, compare);
    printf("%d %d", input[n-1],input[0]);
    
}