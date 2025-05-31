#include <iostream>
#include <vector>

using namespace std;

void dfs(int val, vector<vector<int>>& graph, vector<bool> &visited, int &count) //값 수정하려면 주소 참조 시켜줘야함
{
    visited[val] = true;
    count++;

    for (int i : graph[val])
    {
        if (!visited[i]) {
                dfs(i, graph, visited, count);
            }
    }
}
int main()
{
    int n, m;
    cin >> n >> m;

    vector<bool> visited(n + 1, false);
    vector<vector<int>> arr(n + 1); //2중 백터는 걍 초기화 안해도 됨, 비어있는 상태로 생성됨 알아서
    for (int i = 1; i <= m; i++)
    {
        int temp1, temp2;
        cin >> temp1 >> temp2;
        arr[temp1].push_back(temp2);
        arr[temp2].push_back(temp1); //양방향임
    }
    int count= 0;
    dfs(1, arr, visited, count);
    cout<<count-1;//자기자신은 뺌
    return 0;
}
