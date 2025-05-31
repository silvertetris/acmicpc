#include <stdio.h>

int main(void)
{
    int n = 0;
    int input;
    int temp[10000] = {0};
    int record[10000] = {0};
    scanf("%d", &input);
    temp[n++] = input;
    record[input]=1;
    while (1)
    {
        input = (input % 1000) / 10;
        input *= input;
        if (record[input])
            break;

        record[input] = 1;
        temp[n++] = input;
    }
    printf("%d", n);
    return 0;
}