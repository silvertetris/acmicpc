#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int compare(const void *a, const void *b)
{
    return strcmp((const char *)a, (const char *)b);
}
void reverse(char *str)
{
    int len = strlen(str);
    if(str[0]==NULL) return;
    for (int i = 0; i < len / 2; i++)
    {
        char temp = str[i];
        str[i] = str[len - i - 1];
        str[len - i - 1] = temp;
    }
}
int main(void)
{
    char word[51] = {
        '\0',
    };

    char result[10000][51] = {
        '\0',
    };
    scanf("%s", &word);
    int num = 0;
    for (int i = 1; i < strlen(word) - 1; i++)
    {
        for (int j = i + 1; j < strlen(word); j++)
        {
            char temp[3][51] = {
                '\0',
            };
            for (int k = 0; k < i; k++)
            {
                temp[0][k] = word[k];
            }
            for (int k = i; k < j; k++)
            {
                temp[1][k - i] = word[k];
            }
            for (int k = j; k < strlen(word); k++)
            {
                temp[2][k - j] = word[k];
            }
            reverse(temp[0]);
            reverse(temp[1]);
            reverse(temp[2]);
            sprintf(result[num], "%s%s%s", temp[0], temp[1], temp[2]);
            num++;
        }
    }
    qsort(result, 10000, sizeof(result[0]), compare);

    for (int i = 0; i < 10000; i++)
    {
        if (result[i][0] == '\0')
            continue;
        else
        {
            printf("%s", result[i]);
            break;
        }
    }
}