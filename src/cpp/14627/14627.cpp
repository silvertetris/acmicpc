#include <iostream>
#include <algorithm>
#include <numeric>
#include <vector>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int s, c;
    cin >> s >> c;
    
    vector<int> greenOnion(s);
    for (int i = 0; i < s; i++)
    {
        cin >> greenOnion[i];
    }

    long long totalLength = accumulate(greenOnion.begin(), greenOnion.end(), 0LL);
    int left = 1;
    int right = *max_element(greenOnion.begin(), greenOnion.end());
    int maxPieceLength = 0;

    while (left <= right)
    {
        int mid = (left + right) / 2;
        long long totalPieces = 0;

        for (int i = 0; i < s; i++)
        {
            totalPieces += greenOnion[i] / mid;
        }

        if (totalPieces >= c)
        {
            maxPieceLength = mid;
            left = mid + 1;
        }
        else
        {
            right = mid - 1;
        }
    }

    
    long long remainingOnions = totalLength - (long long)maxPieceLength * c;
    
    cout << remainingOnions << "\n";

    return 0;
}
