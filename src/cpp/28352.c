#include <stdio.h>

int main(void)
{
    long long result =1;

    long long input;
    scanf("%d", &input);
    while(1) {
        result*=input;
        input--;
        if(input ==1) break;
    }
    printf("%d", result/60/60/24/7);
}