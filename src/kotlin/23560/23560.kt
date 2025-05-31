package kotlin.`23560`

fun main() {
    val n = readln().toInt()
    val dp = IntArray(n) {0}

    dp[0] = 2

    for(i in 1 until n) {
        dp[i] = dp[i-1]*3
    }
    //예시 2번을 보면 결국 3가지 경우로 나누는걸 볼 수 있네 아..
    print(dp[n-1])
}