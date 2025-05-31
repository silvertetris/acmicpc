#include <stdio.h>

int main(void) {
    char cambridge[9]={'C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E'};

    char str[101] ={'\0',};
    char result[101]={'\0',};
    scanf("%s", &str);
    int cnt=0;
    for(int i=0; i<101; i++) {
        if(str[i]=='\0') break;
        int temp=1;
        for(int j=0; j<9; j++) {
            if(cambridge[j]==str[i]) {
                temp=0;
                break;
            }
        }
        if(temp==1) {
            result[cnt]=str[i];
            cnt++;
        }
    }
    printf("%s", result);
}