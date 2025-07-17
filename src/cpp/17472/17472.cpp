#include <iostream>
#include <queue>
#include <vector>
using namespace std;

void munion(int a, int b);
int find(int a);
void bfs(int i, int j);

static int dx[] = {1, 0, -1, 0};
static int dy[] = {0, 1, 0, -1};

static int map[101][101];
static bool visited[101][101];
static vector<int> parent;
static int n, m, sNum;
static vector<vector<pair<int, int>>> sumlist;
static vector<pair<int, int>> mlist;

struct Edge {
    int s, e, v;
    bool operator >(const Edge &t) const { return v > t.v; }
};

static priority_queue<Edge, vector<Edge>, greater<Edge>> pq;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> n >> m;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> map[i][j];
    sNum = 1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (map[i][j] == 1 && !visited[i][j]) {
                bfs(i, j);
                sumlist.push_back(mlist);
                sNum++;
            }
        }
    }
    for (int i = 0; i < sumlist.size(); i++) {
        auto &now = sumlist[i];
        for (auto &p : now) {
            int x = p.first, y = p.second, id = map[x][y];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d], dist = 0;
                while (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == id) break;
                    if (map[nx][ny] != 0) {
                        if (dist > 1) pq.push(Edge{id, map[nx][ny], dist});
                        break;
                    }
                    nx += dx[d];
                    ny += dy[d];
                    dist++;
                }
            }
        }
    }
    parent.resize(sNum);
    for (int i = 0; i < sNum; i++) parent[i] = i;
    int used = 0, result = 0;
    while (!pq.empty()) {
        auto e = pq.top(); pq.pop();
        if (find(e.s) != find(e.e)) {
            munion(e.s, e.e);
            result += e.v;
            used++;
        }
    }
    if (used == sNum - 2) cout << result;
    else cout << -1;
    return 0;
}

void munion(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) parent[b] = a;
}

int find(int a) {
    return parent[a] == a ? a : parent[a] = find(parent[a]);
}

void bfs(int i, int j) {
    queue<pair<int, int>> q;
    mlist.clear();
    visited[i][j] = true;
    map[i][j] = sNum;
    q.push({i, j});
    mlist.push_back({i, j});
    while (!q.empty()) {
        auto [x, y] = q.front(); q.pop();
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == 1) {
                visited[nx][ny] = true;
                map[nx][ny] = sNum;
                q.push({nx, ny});
                mlist.push_back({nx, ny});
            }
        }
    }
}
