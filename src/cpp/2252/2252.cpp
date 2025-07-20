#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;
    vector<vector<int> > a(n + 1);
    vector<int> indegree(n + 1);

    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        a[u].push_back(v); //u가 v앞에 서야함 , v 차수 증가
        indegree[v]++;
    }
    queue<int> queue;

    for (int i = 1; i <= n; i++) {
        if (indegree[i] == 0) {
            queue.push(i);
        }
    }
    while (!queue.empty()) {
        int cur = queue.front();
        queue.pop();
        cout << cur << " ";
        for (int next: a[cur]) {
            indegree[next]--;
            if (indegree[next] == 0) {
                queue.push(next);
            }
        }
    }
}
