#include <bits/stdc++.h>

#define ll long long
#define ld long double

using namespace std;

void solve() {
    int n, k;
    cin>>n>>k;
    vector<pair<int, int>> arr(n);
    for(int i=0; i<n;i++) {
        int m, v;
        cin>>m>>v;
        arr[i] = {m, v};
    }
    vector<int> c(k);


    for(int i=0; i<k; i++) {
        cin>>c[i];
    }
    sort(c.begin(), c.end());
    sort(arr.begin(), arr.end());

    ll ans = 0;
    int idx = 0;
    priority_queue<int> pq;
    for(int i=0; i<k; i++) {
        for(int j=idx; j<n; j++) {
            if(arr[j].first<=c[i]) {
                pq.push(arr[j].second);
                idx = j+1;
            } else {
                idx = j;
                break;
            }
        }
        if(!pq.empty()) {
            ans+=pq.top();
            pq.pop();
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