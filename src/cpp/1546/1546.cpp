#include <iostream>
#include <string>
using namespace std;
int main() {
    int n;
    cin>>n;
    int score[n];
    for(int i=0; i<n; i++) {
        cin>>score[i];
    }
    long sum = 0;
    long max = 0;
    for(int i=0; i<n; i++) {
        if(score[i]>max) {
            max = score[i];
        }
        sum = sum+score[i];
    }
    double result = sum*100.0/max/n;
    cout<<result;
}