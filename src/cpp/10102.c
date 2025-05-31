#include <stdio.h>

int main(void) {
    int n=0;
    int a=0;
    int b=0;
    scanf("%d", &n);
    char input[15]={'\0',};

    scanf("%s", &input);

    for(int i=0; i<15; i++) {
        if(input[i]=='A') a++;
        if(input[i]=='B') b++;
    }

    if(a>b) printf("A");
    else if(b>a) printf("B");
    else printf("Tie");

}