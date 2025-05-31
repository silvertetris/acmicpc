#include <stdio.h>

int main(void)
{
    int m;
    int d;
    // 1월 1일은 목요일
    int total = 0;
    scanf("%d %d", &m, &d);
    for (int i = (m - 1); i > 0; i--)
    {
        if (i == 2)
        {
            total += 28;
        }
        else if (i == 4 || i == 6 || i == 9 || i == 11)
        {
            total += 30;
        }
        else
            total += 31;
    }
    total+=d;
    total = total % 7;
    switch (total)
    {
    case 1:
        printf("MON");
        break;
    case 2:
        printf("TUE");
        break;
    case 3:
        printf("WED");
        break;
    case 4:
        printf("THU");
        break;
    case 5:
        printf("FRI");
        break;
    case 6:
        printf("SAT");
        break;
    case 0:
        printf("SUN");
        break;
    }
    return 0;
}