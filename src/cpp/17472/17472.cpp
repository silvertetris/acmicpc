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
static bool visited[101][101] = {false,};
static vector<int> parent;
static int n, m, sNum;
static vector<vector<pair<int, int>>> sumlist; //섬 리스트
static vector<pair<int, int>> mlist;

typedef struct Edge {
    int s, e, v;//start, end , value
    bool operator > (const Edge& temp) const {
        return v> temp.v; //value 기준으로 정렬
    }
} Edge;

static priority_queue<Edge, vector<Edge>, greater<Edge>> pq;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin>> n >> m;
    for(int i =0; i<n; i++) {
        for(int j=0; j<m; j++) {
            cin >> map[i][j];
        }
    }

    sNum = 1;

    for(int i =0; i<n; i++ ) {
        for(int j=0; j<m; j++) {
            if(map[i][j] == 1 && visited[i][j] != true) {
                bfs(i, j);
                sNum++;
                sumlist.push_back(mlist);
            }
        }
    }

    for(int i=0; i< sumlist.size(); i++) {
        vector<pair<int, int>> now = sumlist[i];
        for(int j=0; j< now.size(); j++) {
            int curX = now[j].first;
            int curY = now[j].second;
            int now_s = map[curX][curY];
            for(int d=0; d<4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];
                int dist = 0;

                while(nx >=0 && nx<n && ny >=0 && ny<m) {
                    if(map[nx][ny] == now_s) { //같은 섬
                        break;
                    }
                    else if(map[nx][ny]!=0) {
                        if(dist >1) {
                            pq.push(Edge{now_s, map[nx][ny], dist});
                        }
                        break;
                    }
                    else {
                        dist++;
                    }
                }
            }
        }
    }

    parent.resize(sNum);
    for(int i=0; i<parent.size(); i++) {
        parent[i] = i;
    }

    int useEdge = 0;//간선 카운트
    int result = 0;

    while(!pq.empty()) {
        Edge cur = pq.top();
        pq.pop();
        if(find(cur.s) != find(cur.e)) {
            munion(cur.s, cur.e);
            result += cur.v;
            useEdge++;
        }
    }

    if(useEdge == sNum -2) {
        cout<< result << "\n";
    }else {
        cout<<-1 << "\n";
    }
}

void munion(int a, int b) {
    a = find(a);
    b = find(b);
    if(a!=b) {
        parent[b] = a;
    }
}

int find(int a) {
    if(a==parent[a]) {
        return a;
    } else {
        return parent[a] = find(parent[a]);
    }
}

void bfs(int i, int j) {
    queue<pair<int, int>> q;
    mlist.clear();
    q.push(make_pair(i, j));
    mlist.push_back(make_pair(i, j));
    visited[i][j] = true;
    map[i][j] = sNum;

    while(!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for(int d=0; d<4; d++) {
            int nx = x+dx[d];
            int ny = y+dy[d];
            while(nx>=0 && nx<n && ny>=0 && ny<m) {
                if(!visited[nx][ny] && map[nx][ny]!=0) {
                    map[nx][ny] = sNum;
                    visited[nx][ny] = true;
                    mlist.push_back(make_pair(nx, ny));   
                    q.push(make_pair(nx, ny));
                }
                else {
                    break;
                }
            }
        }
    }
}
