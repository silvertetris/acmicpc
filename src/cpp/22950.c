#include <stdio.h>
#include <string.h>
int main(void)
{
    int result = 0;
    int n = 0;
    scanf("%d", &n);
    char m[n];
    scanf("%s", &m);
    int k = 0;
    scanf("%d", &k);
    int m_digit=0;
    for(int i=0; i<n; i++) {
        if(m[i]=='1') m_digit=1;
    }
    //n-k-1이 음수면 탈출
    for (int i = (n - 1); i > (n-k-1); i--)
    {
        if (m[i] != '0')
            result = 1;
        if((n-k-1)<0) break;
    }

    if (result == 1)
        printf("NO");
    else if(m_digit==0){
        printf("YES");
    }
    else if(m_digit==1 && k>=n) {
        printf("NO");
    }
    else
    {
        printf("YES");
    }
    return 0;
}