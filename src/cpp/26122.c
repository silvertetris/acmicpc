#include <stdio.h>

int main(void)
{
    int n;
    scanf("%d", &n);
    char input[n];
    int result = 0;
    int fliped[2] = {0, 1}; // 바뀌었는지, 스택
    int index = 0;
    scanf("%s", &input);
    char init = input[0];
    for (int i = 1; i < n; i++)
    {
        if (input[i] != init && fliped[0] == 0) // 바뀌는 지점 (처음바뀔때)
        {
            index = i;
            fliped[0] = 1;
            fliped[1]--;

            if (result < 2 * (i - index + 1))
                result = 2 * (i - index + 1); // 최대값 바꾸고
            if (fliped[1] == 0)
            { // 만약 스택이 0이면
                i = index;
                fliped[0] = 0; // 처음 바뀐 지점부터 재시작
                fliped[1] = 1;
                init = input[index];
            }
        }
        else if (input[i] != init && fliped[0] == 1) // 다른거 계속 나올때
        {
            fliped[1]--;

            if (result < 2 * (i - index + 1))
                result = 2 * (i - index + 1); // 최대값 바꾸고
            if (fliped[1] == 0)
            { // 만약 스택이 0이면
                i = index;
                fliped[0] = 0; // 처음 바뀐 지점부터 재시작
                fliped[1] = 1;
                init = input[index];
            }
        }
        else if (input[i] == init && fliped[0] == 1)
        {                                 // 같은거로 또 바뀌면
            if (result < 2 * (i - index)) // 먼저 여태 최대값 도출
                result = (i - index) * 2;
            i = index;
            fliped[0] = 0; // 처음 바뀐 지점부터 재시작
            fliped[1] = 1;
            init = input[index];
        }
        else
        {
            fliped[1]++;
        }
    }
    printf("%d", result);
}