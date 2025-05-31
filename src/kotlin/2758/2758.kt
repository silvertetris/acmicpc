

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val t = br.readLine().toInt()

    /*
    #1. states/subproblems
    dp[i][j] -> i번째 수의 값이 j일때 판별 경우의 수
     */

    val dp = Array(11) {LongArray(2001) {0} }

    //#2. base Cases
    for(i in 0 until dp[0].size) {
        dp[0][i] = 1
    }

    //#3. transitions
    for(i in 1..10) {
        for(j in 1..2000) {
            dp[i][j] = dp[i][j-1] + dp[i-1][j/2]//2배가 안되는 경우의 수 (최근 수의 +1 만 있으니까 전꺼와 변동 없는 경우의수)
            //최근것을 2배로 만드는 경우 : 나머지 0일 경우를 맞출 필요가 없는게 어차피 내림 안하면 +1로 인한 경우의 수들임
        }
    }

    repeat(t){
        val(n, m) = br.readLine().split(" ").map { it.toInt() }
        //#4. final answer
        bw.write("${dp[n][m]}\n")
    }
    bw.flush()
    bw.close()
}