/*#include <iostream>
#include <deque>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    deque<int> dq;
    int n;
    cin>>n;
    for(int i = 1; i<=n; i++) {
        dq.push_back(i);
    }
    while(dq.size()!=1) {
        int temp;
        dq.pop_front();
        temp = dq.front();
        dq.pop_front();
        dq.push_back(temp);
    }

    int answer = dq.front();
    cout<<answer;
}*/
#include <iostream>
#include <queue>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    queue<int> q;
    int n;
    cin>>n;
    for(int i=1; i<=n; i++) {
        q.push(i);
    }
    while(q.size() >1) {
        q.pop();
        q.push(q.front());
        q.pop();
    }
    cout<<q.front();
}