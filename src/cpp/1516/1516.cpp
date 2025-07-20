#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin>>n;
    vector<vector<int>> adj(n+1);
    vector<int> indegree(n+1, 0);
    vector<int> time(n+1, 0);
    for (int i=1; i<=n; i++) {
        cin >>time[i];
        while (1) {
            int u;
            cin >>u;

            if (u == -1) {
                break;
            }
            adj[u].push_back(i);
            indegree[i]++;
        }
    }
    queue<int> q;

    for (int i=1; i<=n; i++) {
        if (indegree[i] == 0) {
            q.push(i);
        }
    }
    //#1. states/subproblems
    //dp[i] = i번째 건물을 짓는대 까지 걸리는 시간
    vector<int> dp (n+1, 0);
    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        for (int neighbor:adj[cur]) {
            indegree[neighbor]--;
            //#3. transitions -> maxOf(인접 먼저 지어저야하는 건물 시간, 현재까지 계산된거)
            dp[neighbor] = max(dp[neighbor], dp[cur] + time[cur]);
            if (indegree[neighbor] == 0) {
                q.push(neighbor);
            }
        }
    }
    for (int i=1; i<=n; i++) {
        //#4. final answer
        cout <<dp[i] + time[i] << "\n";
    }

}