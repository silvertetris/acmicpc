#include <stdio.h>

int main(void)
{
    int n;
    scanf("%d", &n);
    char input[n][80];
    int result[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%s", &input[i]);
        result[i] = 0;
        int temp = 0;
        for (int j = 0; j < 80; j++)
        {
            if (input[i][j] == 'X')
            {
                temp = 0;
            }
            else if(input[i][j]=='O')
            {
                ++temp;
                result[i] += temp;
            }
            else {
                break;
            }
        }
    }
    for (int i = 0; i < n; i++)
    {
        printf("%d\n", result[i]);
    }
}