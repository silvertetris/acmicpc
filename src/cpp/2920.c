#include <stdio.h>

int main(void) {
    int input[8];
    int temp=0;
    for(int i=0; i<8; i++){
        scanf("%d", &input[i]);
    }
    if(input[1]-input[0]==1) temp=1;
    else if(input[1]-input[0]==-1) temp=2;
    else{
        printf("mixed");
        return 0;
    }
    for(int i=1; i<8; i++) {
        if(input[i]-input[i-1]==1 &&temp==1) continue;
        else if(input[i]-input[i-1]==-1 && temp==2) continue;
        else{
            printf("mixed");
            return 0;
        }
    }
    if(temp==1) printf("ascending");
    if(temp==2) printf("descending");
    return
}