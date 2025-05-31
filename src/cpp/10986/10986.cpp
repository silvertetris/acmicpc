#include <iostream>
#include <vector>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, m;
    cin >> n >> m;
    vector<long> s(n, 0);
    vector<long> c(m, 0);
    long answer = 0;
    cin >> s[0];

    for (int i = 1; i < n; i++)
    {
        int temp = 0;
        cin >> temp;
        s[i] = s[i - 1] + temp; // 합 배열 만들기
    }
    for (int i = 0; i < n; i++)
    {
        int remainder = s[i] % m; // 합 배열에서 mod 했을 때 값이 같다면 그 구간합의 mod 는 0임
        if (remainder == 0)
        { // 0이면 어차피 index 0 부터 해당 값 구간까지는 무조건 나누어 떨어짐
            answer++;
        }
        c[remainder]++;
    }
    for (int i = 0; i < m; i++)
    {
        if (c[i] > 1) //mod 값 이 1이 넘으면 겹치는게 있는 것임
        {
            answer = answer + (c[i] * (c[i] - 1) / 2); //nC2 
        }
    }
    cout << answer << "\n";
}