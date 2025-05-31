#include <stdio.h>
#include <limits.h>

// Helper function to calculate the maximum product in a subarray that crosses the midpoint
void maxCrossingProduct(int A[], int left, int mid, int right, int result[])
{
    int sum = 0, min_num = INT_MAX, max_product = INT_MIN;
    int start = mid, end = mid;

    // Calculate left part (mid to left)
    for (int i = mid; i >= left; i--)
    {
        sum += A[i];
        if (A[i] < min_num)
            min_num = A[i];
        int product = sum * min_num;
        if (product > max_product)
        {
            max_product = product;
            start = i;
        }
    }

    int left_sum = sum, left_min = min_num;

    // Calculate right part (mid+1 to right)
    sum = 0;
    min_num = INT_MAX;
    for (int j = mid + 1; j <= right; j++)
    {
        sum += A[j];
        if (A[j] < min_num)
            min_num = A[j];
        int product = (left_sum + sum) * (left_min < min_num ? left_min : min_num);
        if (product > max_product)
        {
            max_product = product;
            end = j;
        }
    }

    // Update the result if max_product is better
    if (max_product > result[2])
    {
        result[2] = max_product;
        result[0] = start;
        result[1] = end;
    }
}

// Divide and Conquer function to find the maximum product
void maxSubarrayProduct(int A[], int left, int right, int result[])
{
    if (left == right)
    {
        // Base case: single element
        int product = A[left] * A[left];
        if (product > result[2])
        {
            result[2] = product;
            result[0] = left;
            result[1] = left;
        }
        return;
    }

    int mid = (left + right) / 2;

    // Recursive calls for left and right halves
    maxSubarrayProduct(A, left, mid, result);
    maxSubarrayProduct(A, mid + 1, right, result);

    // Find the maximum crossing subarray product
    maxCrossingProduct(A, left, mid, right, result);
}

int main(void)
{
    int N;
    scanf("%d", &N);
    int A[N];
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &A[i]);
    }

    int result[3] = {0, 0, INT_MIN}; // {start, end, max_product}
    maxSubarrayProduct(A, 0, N - 1, result);

    printf("%d\n%d %d", result[2], result[0] + 1, result[1] + 1);
    return 0;
}
