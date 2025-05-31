#include <stdio.h>
#define SIZE  100

int main(void)
{
    int result [200]={0};
    char alpha[SIZE];
    scanf("%s", alpha);
    for(int i=0; i<SIZE; i++) {
        if(alpha[i] ==NULL) {
            break;
        }
        result[alpha[i]]++;
    }
    for(int i=97; i<123; i++) {
        printf("%d ", result[i]);
    }
    return 0;
}