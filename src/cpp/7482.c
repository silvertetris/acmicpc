#include <stdio.h>
#include <math.h>

int main(void)
{
    int n;
    scanf("%d", &n);
    double input[n]; // a 값
    double result[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%lf", &input[i]);
    }
    for (int i = 0; i < n; i++)
    {
        double max = 0;
        int j=4;
        while (1)
        {
            double b = input[i] / j;
            double temp = pow(((j-2)*b),2)*b;
            if (max > temp)
                break;
            max=temp;
            j++;
            result[i] = b;
        }
    }

    for (int i = 0; i < n; i++)
    {
        printf("%.10f\n", result[i]);
    }
}