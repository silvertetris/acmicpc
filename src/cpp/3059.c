#include <stdio.h>
#include <string.h>
int main(void) {
    int n;
    scanf("%d", &n);
    int result[n];
    for(int i=0; i<n; i++) {
        result[i]=0;
        int num = 2015;
        char input[1001] = {'\0',};
        scanf("%s", &input);
        for(int j = 65; j<91; j++) {
            if(strchr(input, j)){
                num -=j;
            } 
        }
        result[i]=num;
    }
    for(int i=0; i<n; i++) {
        printf("%d\n", result[i]);
    }
}