#include <iostream>
#include <cmath>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    //a/b? 유리수? 그니까 안나눠지는거 구하라는건가 -> 서로 서로소인것이 누적됨 -> 누적 배열
    int preSum[10001];
    preSum[0] = 1;
    preSum[1] = 1;
    for (int i=2; i<=10000; i++) {
        int temp = i;
        int result = i;
        for (int j=2; j<=sqrt(i); j++) {
            if (temp%j==0) {
                result = result - result / j;
            }
            while (temp%j==0) {
                temp/=j;
            }
        }
        if (temp>1) {
            result = result - result / temp;
        }
        preSum[i] = preSum[i-1] + result;
    }

    int t;
    cin>>t;
    while (t--) {
        int n;
        cin>>n;
        cout<<preSum[n]+1<<"\n";
    }
}