#include <stdio.h>

int main(void)
{
    int n = 0;
    scanf("%d", &n);
    int result[n];
    for (int i = 0; i < n; i++)
    {
        int dwarf = 0;
        int ork = 0;
        int a, b, c, d, e, f, g =0;
        scanf("%d %d %d %d %d %d", &a, &b, &c, &d, &e, &f);
        dwarf+=a;
        dwarf+= b*2;
        dwarf+= c*3;
        dwarf+= d*3;
        dwarf+= e*4;
        dwarf+= f*10;
        scanf("%d %d %d %d %d %d %d", &a, &b, &c, &d, &e, &f, &g);
        ork+=a;
        ork+=b*2;
        ork+=c*2;
        ork+=d*2;
        ork+=e*3;
        ork+=f*5;
        ork+=g*10;
        if (dwarf > ork)
        {
            result[i] = -1;
        }
        else if (dwarf < ork)
        {
            result[i] = 1;
        }
        else
        {
            result[i] = 0;
        }
    }
    for (int i = 0; i < n; i++)
    {
        if (result[i] == 1)
        {
            printf("Battle %d: Evil eradicates all trace of Good\n", i + 1);
        }
        else if (result[i] == -1)
        {
            printf("Battle %d: Good triumphs over Evil\n", i + 1);
        }
        else
        {
            printf("Battle %d: No victor on this battle field\n", i + 1);
        }
    }
    return 0;
}