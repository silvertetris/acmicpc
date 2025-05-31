#include <stdio.h>
#include <string.h>

int main(void)
{
    int n;
    scanf("%d", &n);
    char result[n][161];
    memset(result, '\0', sizeof(result));
    for (int i = 0; i < n; i++)
    {
        int j;
        scanf("%d", &j);
        char word[20]={'\0',};
        scanf("%s", &word);
        int temp = 0;
        for (int k = 0; k < 20; k++)
        {

            if(word[k]=='\0') break;
            for (int p = 0; p < j; p++)
            {
                result[i][temp+p] = word[k];
            }
            temp+=j;
        }
    }
    for(int i=0; i<n; i++) {
        printf("%s\n", &result[i]);
    }
}