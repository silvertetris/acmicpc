#include <stdio.h>

int main(void)
{
    char input[1000001]={'\0',};
    int result=1;
    scanf("%[^\n]s", &input);

    for(int i=0; i<1000001; i++) {
        if(input[i]==32){
            result++;
            continue;
        }
        if(input[i]=='\0' && input[i-1]==32){
            result--;
            break;
        }
        if(input[i]=='\0') break;
    }
    if(input[0]==32) result--;
    printf("%d", result);
}