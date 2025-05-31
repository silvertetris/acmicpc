#include <stdio.h>

int main(void) {
    int a,b,c=0;
    scanf("%d %d %d",&a, &b, &c);

    if((a+b+c)!=180) printf("Error");
    else if(a==b && b==c && c==60) printf("Equilateral");
    else if(a==b||b==c||a==c) printf("Isosceles");
    else printf("Scalene");
    return 0;
}