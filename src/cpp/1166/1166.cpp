#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    double n, l, w, h;
    cin>>n>>l>>w>>h;
    double answer=0;
    double low = 0;
    double high = min({l, w, h}); // Correct way to find the smallest dimension
    for(int i=0; i<100; i++) {
        double mid =(low+high)/2;
        long long int a = floor(l / mid) * floor(w / mid) * floor(h / mid);
        if(n<=a) {//n 이 더 작다면, 크기를 키워서 a 값을 줄일 수 있음 -> 더 만들 수 있다는 뜻
            answer =mid;
            low = mid;
        }
        else {
            high = mid;
        }
    }
    cout<<fixed;
    cout.precision(10);
    cout<<answer;
}