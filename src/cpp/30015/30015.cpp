#include <bits/stdc++.h>

#define ll long long
#define ld long double

using namespace std;

void solve() {
    int n, k;
    cin>>n>>k;
    vector<int> a(n);
    for(int i=0; i<n; i++) {
        cin>>a[i];
    }
    sort(a.begin(), a.end(), greater<int>());
    vector<vector<int>> width(20, vector<int>());
    int maximum = -1;
    bool find = false;
    string ans;
    for(int i=0; i<n; i++) {
        int bitsize = bit_width((unsigned)a[i]);
        string temp = bitset<20>(a[i]).to_string().substr(20 - bitsize);
        if(maximum>temp.size() && find) {
            break;
        }
        for(int j=0; j<bitsize; j++) {//msb부터
            if(temp[j] == '1') {
                width[20-temp.size()+j].push_back(a[i]);
            }
        }
        if(width[20-temp.size()].size()>=k) {
            find = true;
            maximum = temp.size();
        }//20 * 10^5
    }
    if(maximum==-1) {
        cout<<0<<"\n";
        return;
    }
    vector<int> temp = width[20-maximum];
    for(int i=20-maximum; i<20; i++) {
        int idx = 19-i;
        vector<int> next;
        for(int x :temp) {
            if((x>>idx)&1) {
                next.push_back(x);
            }
        }
        if(next.size()>=k) {
            ans+="1";
            temp=next;
        }
        else {
            ans+="0";
        }
    }
    int result = stoi(ans, nullptr, 2);
    cout<<result<<"\n";

}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    solve();
}