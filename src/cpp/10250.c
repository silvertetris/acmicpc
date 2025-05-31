#include <stdio.h>

int main (void) {
    int n;
    scanf("%d", &n);
    int x[n];
    int y[n];
    for(int i=0; i<n; i++) {
        int h, w, p;//y길이, x 길이, 손님 차례
        //y부터 사람을 채운다.
        scanf("%d %d %d", &h, &w, &p);
        y[i]=p%h;
        x[i]=(p/h)+1;
        if(p%h==0) {
            y[i] = h;
            x[i]=p/h;
        }
    }
    for(int i=0; i<n; i++) {
        printf("%d%02d\n", y[i],x[i]);
    }
}