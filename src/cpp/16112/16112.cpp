#include <iostream>
#include <algorithm>
using namespace std;
typedef long long ll;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, k;
    cin >> n >> k;
    int a[n];
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    sort(a, a + n);

    ll preSum[k + 1];
    fill(preSum, preSum + k + 1, 0);
    ll answer = 0;
    for (int i = 1; i < k; i++)
    {
        preSum[i] = preSum[i - 1] + i * (ll)a[i];
    }
    for (int i = k; i < n; i++)
    {
        answer += a[i];
    }
    cout << preSum[k - 1] + (ll)k * answer;
}
