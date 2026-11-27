#include <bits/stdc++.h>

#define ll long long
#define ld long double

using namespace std;

void solve() {
    
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    while(true) {
        int t;
        cin>>t;
        int zero = 0;
        vector<int> arr;
        if(t==0) break;
        else {
            while(t--) {
                int u;
                cin>>u;
                if(u==0) {
                    zero++;
                    continue;
                }
                arr.push_back(u);        
            }
        }
        sort(arr.begin(), arr.end(), greater<int>());
        string a;
        string b;
        bool flag = false;
        while(!arr.empty()&&zero!=0) {
            if(!flag) {
                if(a.empty()||zero==0) {
                    a+=to_string(arr.back());
                    arr.pop_back();
                }else {
                    a+="0";
                    zero--;
                }
                flag = !flag;
            }else {
                if(b.empty() ||zero==0) {
                    b+=to_string(arr.back());
                    arr.pop_back();
                }else {
                    b+="0";
                    zero--;
                }
                flag = !flag;
            }
        }
        int first = stoi(a);
        int second = stoi(b);
        int total = first+second;
        cout<<total<<"\n";
    }
}