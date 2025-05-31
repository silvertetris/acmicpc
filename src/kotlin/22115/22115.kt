

fun main() {
    val br = System.`in`.bufferedReader()
    val(n, k) = br.readLine().split(" ").map { it.toInt() }
    val c = br.readLine().split(" ").map { it.toInt() }
    /* #1. states/ subproblems
    dp[i] = 값이 i 일때 최소 고른 횟수 값
     */
    val dp = IntArray(100001) {Int.MAX_VALUE-1}
    //#2. base Cases
    dp[0] = 0

    //#3. transition
    for(i in 0 until n) {
        for(j in k downTo c[i]) {
            dp[j] = minOf(dp[j], dp[j-c[i]]+1) //기존 dp[j]가 작냐 , 해당 index의 수를 더 했을 때 수가 작냐
        }
    }

    //#4. final answer
    if(dp[k] == Int.MAX_VALUE-1) {
        print(-1)
    } else {
        print(dp[k])
    }
}