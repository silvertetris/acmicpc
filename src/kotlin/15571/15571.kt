import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val MOD = 1999

    // 2^(N-1) mod 1999
    var p = 1
    repeat(n-1) {
        p = (p * 2) % MOD
    }

    // dp[i]: 폭 i인 보드를 채우는 경우의 수 mod 1999
    val dp = IntArray(m + 1)
    dp[0] = 1

    // windowSum = sum of dp[i - k] for k=1..(N-1); 초기 m=1 때를 맞추기 위해
    var windowSum = if (n > 1) dp[0] else 0

    for (i in 1..m) {
        // dp[i] = sum_{k=1..N-1} dp[i-k]  +  (i>=N ? 2^(N-1)*dp[i-N] : 0)
        var v = windowSum
        if (i >= n) {
            v = (v + p * dp[i - n]) % MOD
        }
        dp[i] = v

        // 다음 i+1 계산을 위해 windowSum 갱신
        windowSum = (windowSum + dp[i]) % MOD
        if (i >= n - 1) {
            windowSum = (windowSum - dp[i - (n - 1)] + MOD) % MOD
        }
    }

    println(dp[m])
}
