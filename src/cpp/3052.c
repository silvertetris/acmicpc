#include <stdio.h>

int main(void) {
    int result[10];
    int final=0;
    int input[10]={0,};
    for(int i=0; i<10; i++) {
        result[i]=-1;
    }
    for(int i=0; i<10; i++) {
        scanf("%d", &input[i]);
        result[i]=input[i]%42;
    }
    for(int i=0; i<9; i++) {
        for(int j=i+1; j<10; j++) {
            if(result[i]==-1 || result[j]==-1) continue;
            else if(result[i]==result[j]) result[j]=-1;
        }
    }
    for(int i=0; i<10; i++) {
        if(result[i]!=-1) final++;
    }
    printf("%d", final);
    return 0;
}