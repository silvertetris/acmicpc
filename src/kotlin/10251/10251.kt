

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val (m, n, l, g) = br.readLine().split(" ").map { it.toInt() }
        val nFuel = Array(m) { IntArray(n) { 0 } } //가로로 가는 연료
        val mFuel = Array(m) { IntArray(n) { 0 } }//아래로 가는 연료

        //각 좌표에 대해서 하나씩 밀기
        //가로로 가는건 우로 한칸
        for (i in 0 until m) {
            nFuel[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        }
        //아래로 가는건 아래로 한칸
        for (i in 0 until m - 1) {
            mFuel[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        }

        /*
        #1. states/ subproblems
        dp[i][j][k][p] = i, j 좌표에 대해서 k번 턴했을때, p방향 (0: 아래, 1: 우) 최소 연료 값
         */
        val INF = Int.MAX_VALUE/2
        val maxTurn = m+n-2
        val dp = Array(m + 1) {
            Array(n + 1) {
                Array(maxTurn+1) { IntArray(2) { INF } }
            }
        }//i, j, 턴 횟수, 위 아님 아래(0이면 아래, 1이면 우)
        //100*10*200*2 = 400,000 (EACH TEST CASE)
        //#2. Base Cases
        dp[0][0][0][0] = 0
        dp[0][0][0][1] = 0

        //#3. transition
        for (i in 0 until m) {
            for (j in 0 until n) {
                for (k in 0..minOf(i + j, maxTurn)) {
                    if (dp[i][j][k][0] == INF && dp[i][j][k][1] == INF) continue

                    if (i + 1 < m) {
                        dp[i + 1][j][k][0] =
                            minOf(dp[i + 1][j][k][0], dp[i][j][k][0] + mFuel[i][j]) //그대로 아래 (그 앞의 경로 뽑음)
                        dp[i + 1][j][k + 1][0] =
                            minOf(dp[i + 1][j][k + 1][0], dp[i][j][k][1] + mFuel[i][j])//우로 가던놈 꺾은 거랑 비교 (턴할때)
                    }
                    if (j + 1 < n) {
                        dp[i][j + 1][k][1] = minOf(dp[i][j + 1][k][1], dp[i][j][k][1] + nFuel[i][j])
                        dp[i][j + 1][k + 1][1] = minOf(dp[i][j + 1][k + 1][1], dp[i][j][k][0] + nFuel[i][j])
                    }
                }
            }
        }

        //#4. final answer
        var ans = -1
        for (i in 0..maxTurn) {
            if (dp[m - 1][n - 1][i][0] <= g || dp[m - 1][n - 1][i][1] <= g) {
                ans = i + (l*(m-1 + n-1))
                break
            }
        }
        bw.write("$ans\n")
    }
    bw.flush()
}
/*
결국 연료량만을 비교해서 목적지를 턴에 따라서 보고, [i][j] 목적지 좌표에 대해 연료가 g 보다 작을 경우의 턴 횟수를 봄
어차피 절대적 최소 도착시간은 정해져 있고 거기다가 최소 턴을 더하면 되는 dp 문제
dp를 답인 시간으로 두지 않는 문제.
 */