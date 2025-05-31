#include <stdio.h>

int main(void)
{
    int n;
    scanf("%d", &n);
    char input[n][51];
    for(int i=0; i<n; i++) {
        scanf("%s", &input[i]);
    }
    char result[51]={'\0',};
    for(int i=0; i<51; i++) {
        result[i]=input[0][i];
    }

    for(int i=0; i<n; i++) {
        for(int j=0; j<51; j++) {
            if(result[j]!=input[i][j]) {
                result[j]='?';
            }
        }
    }
    printf("%s", result);
    return 0;
}