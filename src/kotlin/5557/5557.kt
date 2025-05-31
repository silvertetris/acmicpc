package kotlin.`5557`

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    /*
    #1. states/subproblems
    dp[i][j] = i인덱스일 때 계산값이 j 일 때 경우의 수
     */
    val dp = Array(n) { LongArray(21) { 0L } }

    //#2. Base Cases
    dp[0][arr[0]] = 1


    //#3. transitions
    for (i in 1 until n-1) {
        for (j in 0..20) {
            if (j - arr[i] >= 0) {
                dp[i][j - arr[i]] += dp[i - 1][j]
            }
            if (j + arr[i] <= 20) {
                dp[i][j + arr[i]] += dp[i - 1][j]
            }
        }
    }
    //#4. final answer
    print(dp[n - 2][arr[n-1]])
    //n-1 이 아닌 이유는 마지막에 = 해서 결과값 나온다했잖아 제발 뭔가 헷갈리면 시간낭비하지말고 문제를 한번 더 봐 제발 대충 보지말고
}