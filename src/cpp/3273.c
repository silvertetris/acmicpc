#include <stdio.h>
#include <stdlib.h>
int compare(const void *a, const void *b)
{
    return *(int *)a - *(int *)b;
}
int main(void)
{
    int n;
    scanf("%d", &n);
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    qsort(arr, n, sizeof(int), compare);
    int x;
    scanf("%d", &x);
    int result = 0;
    int left =0;
    int right =n-1;

    while(right>left) {
        int temp = arr[left] +arr[right];
        if(temp==x) {
            result++;
            left++;
            right--;
        }
        else if(temp>x) {
            right--;
        }
        else{
            left++;
        }
    }
    printf("%d", result);
}