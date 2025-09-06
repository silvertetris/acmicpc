fun main() {
    val(n, k) = readln().split(" ").map { it.toInt() }
    val dp = IntArray(n+1) {Int.MAX_VALUE -100000}
    dp[0] = 0
    for(i in 0 until n) {
        dp[i+1] = minOf(dp[i+1], dp[i] +1)
        if(i+i/2<=n) {
            dp[i+i/2] = minOf(dp[i+i/2], dp[i] +1)
        }
    }
    if(dp[n] >k) {
        print("water")
    }
    else {
        print("minigimbob")
    }
}