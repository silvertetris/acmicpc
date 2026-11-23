#include <bits/stdc++.h>

#define ll long long
#define ld long double

using namespace std;

void solve() {
    int n;
    cin>>n;
    if(n==3) {
        cout<<"-1\n";
        return;
    }
    if(n%2==0) {
        for(int i=3; i<=n; i++) {
            cout<<i<<"\n";
        }
        cout<<1<<"\n"<<2<<"\n";
    }
    else {
        for(int i=2; i<=n-2; i++) {
            cout<<i<<"\n";
        }
        cout<<n<<"\n"<<1<<"\n"<<n-1<<"\n";
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    solve();
}