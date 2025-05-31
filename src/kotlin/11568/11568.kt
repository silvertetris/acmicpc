

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val card = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n) {1}
    for(i in 0 until n) {
        for(j in 0 until i) {
            if(card[j]<card[i]) {
                dp[i] = maxOf(dp[i], dp[j]+1) // dp[i] = 그 전까지 연산해온 최대 수열, dp[j]+1, 그전까지 해온 dp[j]의 연산을 최근으로 i번째를 뒤에 덧붙임
            }
        }
    }
    print(dp.max())
}