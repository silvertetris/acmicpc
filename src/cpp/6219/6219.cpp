#include <bits/stdc++.h>

#define ll long long
#define ld long double

using namespace std;

void solve() {
    int a, b, d;
    cin>>a>>b>>d;

    vector<bool> isPrime(b+1, false);
    for(auto i=2; i*i<=b; i++) {
        if(isPrime[i])continue;
        for(auto j = i*i; j<=b; j+=i) {
            isPrime[j] = true;
        }
    }
    int ans = 0;
    for(int i = a; i<=b; i++) {
        if(isPrime[i]) continue;
        for(int j = i;  j>0; j/=10) {
            if(j%10==d) {
                ans++;
                break;
            }
        }
    }

    cout<<ans<<"\n";
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    solve();
}