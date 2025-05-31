#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin>>n;
    vector<int> a(n, 0);
    vector<int> answer(n, 0);

    for(int i=0; i<n; i++) {
        cin >> a[i]; //배열 저장
    }

    stack<int> myStack; // 스택에 넣는건 a 의 index
    myStack.push(0);

    for(int i=1; i<n; i++) {
        while(!myStack.empty() && a[myStack.top()] < a[i]) { //stack 에 넣고 반복 확인하지 않고 stack에 뽑힐때마다 바로바로 answer에 대입
            answer[myStack.top()] = a[i];
            myStack.pop();
        }
        myStack.push(i);
    }
    while(!myStack.empty()) {
        answer[myStack.top()] = -1;
        myStack.pop();
    }
    for(int i=0; i<n; i++) {
        cout<<answer[i]<<" ";
    }
}