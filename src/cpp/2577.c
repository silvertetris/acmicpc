#include <stdio.h>

int main(void)
{
    int a, b, c = 0;
    scanf("%d %d %d", &a, &b, &c);
    int num = a * b * c;
    char result[15];
    sprintf(result, "%d", num);
    int temp[10] = {0};
    for (int i = 0; result[i] != '\0'; i++)
    {
        int digit = result[i] - '0';
        temp[digit]++;
    }
    for (int i = 0; i < 10; i++)
    {
        printf("%d\n", temp[i]);
    }

    return 0;
}