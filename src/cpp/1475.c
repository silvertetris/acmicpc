#include <stdio.h>

int main(void)
{
    int input;
    scanf("%d", &input);
    char str[7];
    sprintf(str, "%d", input);
    int result[10]={0};
    for (int i = 0; i < 7; i++)
    {
        int digit = str[i] - '0';
        result[digit]++;
    }
    result[6] += result[9];
    result[9] = 0;
    int max_num = 0;
    for (int i = 0; i < 10; i++)
    {
        if (result[i] > max_num)
        {
            if(i==6) {
                if((result[i]/2)+(result[i]%2)>max_num) {
                    max_num=(result[i]/2)+(result[i]%2);
                    continue;
                }
                else{
                    continue;
                }
            }
            max_num = result[i];
        }
    }
    printf("%d", max_num);
    return 0;
}