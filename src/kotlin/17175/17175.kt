fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = LongArray(n + 1)
    if(n==1||n==0) {
        print(1)
        return
    }
    else {
        dp[0] = 1
        dp[1] = 1
        for(i in 2.. n) {
            dp[i] = (dp[i-1] + dp[i-2] +1)%1_000_000_007
        }
    }
    print(dp[n]%1_000_000_007)
}