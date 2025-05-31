

fun main() {
    val n = readln().toInt()
    val dp= BooleanArray(n+1) {false}
    if(n<=4) {
        if(n ==2) {
            print("CY")
        } else{
            print("SK")
        }
        return
    }
    dp[1] = true
    dp[2] = false
    dp[3] = true
    dp[4] = true
/*
dp[i] -> 돌의 선택은 1, 3 4

dp[i] -> 남은 돌 개수가 i 일때 승자

dp[i] = dp[i-1]+dp[i-3]+ dp[i-4] 만약이 3개가 다 승자가 같다면 반대편이 이김

1 1 s
2 1 1 c
3 3 s
4 4 s
5 3 1 1 s
6 4 1 1 s
7 1 4 1 1 c
8
 */
    for(i in 5.. n) {
        dp[i] = !(dp[i-1]&&dp[i-3]&&dp[i-4])
    }

    if(dp[n]) {
        print("SK")
    } else {
        print("CY")
    }
}