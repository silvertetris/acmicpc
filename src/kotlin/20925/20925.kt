package kotlin.`20925`

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, t) = br.readLine().split(" ").map { it.toInt() }
    val c = IntArray(n)
    val e = IntArray(n)
    for (i in 0 until n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        c[i] = temp[0]
        e[i] = temp[1]
    }
    val time = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        time[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    //#1. states/subproblems
    //dp(i, j) = i 사냥터에서 j 시간대에서의 최대 경험치
    val dp = Array(n) { IntArray(t + 1) { -1 } }

    //#2. Base Cases => 0인 사냥터 부터 찾기
    for (i in 0 until n) {
        if (c[i] == 0) dp[i][0] = 0
    }

    //#3. transition
    for (j in 0 until t) {
        for (i in 0 until n) {
            if (dp[i][j] < 0) continue//아직 입장 불가능
            if (j + 1 <= t) { //그대로 사냥할 경우 +1
                dp[i][j + 1] = maxOf(dp[i][j + 1], dp[i][j] + e[i]) //여태 전 최대값, 지금 당장 사냥 +1
            }
            for (k in 0 until n) { //옮길 경우 (현재 사냥터 j 에서 k로)
                if (k == i) continue //같은 사냥터 제외
                if (j + time[i][k] <= t) { //knapsack (제한된 사간에서 최대 경험치 찾기)
                    if (dp[i][j] >= c[k]) { //최소 입장컷보단 높아야함
                        dp[k][j + time[i][k]] = maxOf(dp[k][j + time[i][k]], dp[i][j])
                    }
                }
            }
        }
    }

    //#4. final answer
    var answer = 0
    for (i in 0 until n) {
        answer = maxOf(answer, dp[i][t])
    }
    print(answer)
}