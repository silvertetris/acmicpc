#include <iostream>
#include <cmath>
using namespace std;

int eular(int n) {
    if (n ==1) {
        return 0;
    }
    int result = n;
    for (int i=2; i<=sqrt(n); i++) {
        if (n%i==0) {
            result = result - result / i;
        }
        while (n%i==0) {
            n/=i;
        }
    }
    if (n>1) {
        result = result - result / n;
    }
    return result;
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int t;
    cin>>t;
    while (t--) {
        int p;
        cin>>p;
        if (p%2==0) {
            cout<<eular(p) + eular(p/2) <<"\n";
        }else {
            cout<<eular(p) << "\n";
        }
    }
}