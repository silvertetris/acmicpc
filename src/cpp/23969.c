#include <stdio.h>

int main(void)
{
    int n = 0;
    int k = 0;
    int cnt = 0;

    scanf("%d %d", &n, &k);

    int a[n];
    int b[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }

    for (int i = n; i > 1; i--)
    {
        for (int j = 0; j < n - 1; j++)
        {
            if (a[j] > a[j + 1])
            {
                int temp = 0;
                temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
                cnt++;
                if(cnt==k) {
                    for(int k=0; k<n; k++) {
                        b[k]=a[k];
                    }
                }
            }
        }
    }
    if (cnt < k)
    {
        printf("%d", -1);
    }
    else
    {
        for (int i = 0; i < n; i++)
        {
            printf("%d ", b[i]);
        }
    }
}