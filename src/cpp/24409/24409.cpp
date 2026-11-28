#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    string s, t;
    int Q;
    cin >> s >> t >> Q;

    bool bad[18][18] = {};
    for (int x = 0; x < 18; x++)
        for (int y = x; y < 18; y++) {
            string a, b;
            for (char c : s) if (c - 'a' == x || c - 'a' == y) a += c;
            for (char c : t) if (c - 'a' == x || c - 'a' == y) b += c;
            bad[x][y] = (a != b);
        }

    string ans;
    while (Q--) {
        string input;
        cin >> input;
        bool ok = true;
        for (int i = 0; i < input.size(); i++)
            for (int j = i; j < input.size(); j++)
                if (bad[input[i] - 'a'][input[j] - 'a']) ok = false;
        ans += ok ? 'Y' : 'N';
    }
    cout << ans << "\n";
}