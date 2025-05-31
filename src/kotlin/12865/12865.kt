package kotlin.`12865`

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    /*
    1. states/subproblems
    dp[i][j] = 담은 물건 수, 물건을 담았을 때 최대 value j
     */
    val dp = Array(n+1) { IntArray(k+1) {0} }
    val w = IntArray(n+1) {0}
    val v = IntArray(n+1) {0}
    for(i in 0 until n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        w[i] = temp[0]
        v[i] = temp[1]
    }
    //2. base cases -> 아무것도 안담았으니 0
    //3. transition
    for(i in 1 ..n) {
        for(j in 0..k) {
            dp[i][j] = dp[i-1][j]
            if(w[i-1]<=j) {
                dp[i][j] = maxOf(dp[i][j], v[i-1]+dp[i-1][j-w[i-1]])
            }
        }
    }
    print(dp[n][k])
}