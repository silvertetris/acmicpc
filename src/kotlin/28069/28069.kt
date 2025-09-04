fun main() {
    val(n, k) = readln().split(" ").map { it.toInt() }
    val dp = IntArray(n+1) {Int.MAX_VALUE -100000}
    dp[0] = 0
    for(i in 1.. n) {
        var temp = -1
        if (i % 3 == 0) {
            temp = i *2 /3
        } else if (i % 3 == 1 && i != 1) {
            temp = 2 * ((i - 1) / 3) + 1
        }
        dp[i] = if (temp >= 0) {
            minOf(dp[i - 1] + 1, dp[temp] + 1)
        } else {
            dp[i - 1] + 1
        }
    }
    if(dp[n] >k) {
        print("water")
    }
    else {
        print("minigimbob")
    }
}