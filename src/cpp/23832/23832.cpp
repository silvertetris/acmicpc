#include <iostream>
#include <cmath>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin>>n;
    vector<int> preSum(n+1, 0);
    for (int i=2; i<=n; i++) {
        int p = i;
        int result = i;
        for (int j=2; j<=sqrt(i); j++) {
            if (p%j==0) {
                result = result - result / j;
            }
            while (p%j==0) {
                p/=j;
            }
        }
        if (p>1) {
            result = result - result / p;
        }
        preSum[i] = preSum[i-1] + result;
    }
    cout<<preSum[n]<<"\n";
}