

fun main() {
    val (w, h) = readln().split(" ").map { it.toInt() }
    //#1. states/ subproblems
    val dp = Array(w+1) {Array(h+1){Array(2) { IntArray(2) {0} } } }
    //좌표, 방향, 방향을 바꿨을 때 안바꿨을 때
    //0이면 북으로 가던놈, 1이면 우로 가던넘
    val MOD = 100_000

    //#2. base Cases (각 초기 좌표에 대한 경우의 수 = 1 (좌아래 끝 선분))
    for(i in 1..w) {
        dp[i][1][0][0] = 1
    }
    for(i in 1.. h) {
        dp[1][i][1][0] = 1
    }

    //#3. transition
    for(i in 2.. w) {
        for(j in 2.. h) {
            dp[i][j][0][0] = (dp[i-1][j][0][0] + dp[i-1][j][1][1])%MOD//위로 방향을 안바꿀 경우 -> 그전 직진, 그전에서 방향을 바꾼놈 (j-1이 아닌 i-1에서 역방향으로 가던놈이 꺾은 거니까)
            dp[i][j][0][1] = (dp[i][j-1][0][0])%MOD//전단계에서는 방향 바꾼넘 더하면 안됨 (바로 바꾸기 불가능)
            dp[i][j][1][0] = (dp[i][j-1][1][0]+dp[i][j-1][0][1])%MOD
            dp[i][j][1][1] = (dp[i-1][j][1][0])%MOD

        }
    }
    //#4. final answer
    print((dp[w][h][0][0] + dp[w][h][1][1]+dp[w][h][0][1]+dp[w][h][1][0])%MOD)
}