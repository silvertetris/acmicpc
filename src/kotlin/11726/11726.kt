package kotlin.`11726`

fun main() {
    val n = readln().toInt()
    val dp = IntArray(n+1) {0}

    dp[1] = 1
    if(n==1) {
        print(1)
        return
    }
    dp[2] = 2

    for(i in 3 ..n) {
        dp[i] = (dp[i-1]+dp[i-2])%10007
    }
    print(dp[n])
}