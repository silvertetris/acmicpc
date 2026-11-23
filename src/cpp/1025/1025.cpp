#include <bits/stdc++.h>

#define ll long long

using namespace std;
/*
1. 
*/
vector<int> isprime;
void solve() {
    int n, m;
    cin>>n>>m;

    vector<vector<int>> arr(n, vector<int>(m, 0));
    for(int i=0; i<n; i++) {
        string temp;
        cin>>temp;
        for(int j=0; j<m; j++) {
            arr[i][j] = temp[j]-'0';
        }
    }

}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    for(int i=0; i<=31623; i++) {
        isprime.push_back(i*i);
    }
    solve();
}