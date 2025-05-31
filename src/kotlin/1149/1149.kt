package kotlin.`1149`

fun main() {
    val N = readLine()!!.toInt()
    val costs = Array(N) { IntArray(3) }

    //각 줄에 대한 비용 배열 초기화
    for (i in 0 until N) {
        val (r, g, b) = readLine()!!.split(" ").map { it.toInt() }
        costs[i][0] = r
        costs[i][1] = g
        costs[i][2] = b
    }

    //1. find states/ subproblems
    val dp = Array(N) { IntArray(3) }

    // 2. Base Cases
    //각각 다른 색으로 먼저 칠했을 때
    dp[0][0] = costs[0][0]
    dp[0][1] = costs[0][1]
    dp[0][2] = costs[0][2]

    // 3. find transitions
    //i 번째 집을, j 색으로 칠할때, 전 dp 에 있는 경우(j를 제외한) 중에 최소 값 + 칠하려는 j 색 비용 => i번 째 집을 j색으로 칠할때 총 비용
    for (i in 1 until N) {
        dp[i][0] = minOf(dp[i-1][1], dp[i-1][2]) + costs[i][0]
        dp[i][1] = minOf(dp[i-1][0], dp[i-1][2]) + costs[i][1]
        dp[i][2] = minOf(dp[i-1][0], dp[i-1][1]) + costs[i][2]
    }

    // 4. final answer
    val result = minOf(dp[N-1][0], dp[N-1][1], dp[N-1][2])
    println(result)
}