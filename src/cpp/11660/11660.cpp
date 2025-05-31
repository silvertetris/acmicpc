#include <iostream>
#include <vector>
using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, m;
    cin>>n>>m;
    vector<vector<int>> d (n+1, vector<int>(n+1, 0));//합 구하는 자료
    int arr[n+1][n+1] = {0,};
    for(int i =1; i<=n; i++) {
        for(int j =1; j<=n; j++) {
            cin>>arr[i][j];
            d[i][j] = d[i][j-1] + d[i-1][j] - d[i-1][j-1] + arr[i][j]; //각 사방면의 합
        }
    }
    for(int i=0; i<m; i++) {
        int x1, y1, x2, y2;
        cin>>x1>>y1>>x2>>y2;
        int result = d[x2][y2] - d[x1-1][y2] - d[x2][y1-1] + d[x1-1][y1-1];
        cout<<result<<"\n";
    }
}