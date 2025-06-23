fun main() {
    val br = System.`in`.bufferedReader()
    val(n, m) = br.readLine().split(" ").map { it.toInt() }//m = 크기 맞지 않은 돌 갯수
    val small = BooleanArray(n+1) {false}
    for(i in 0 until m) {
        val temp = br.readLine().toInt()
        small[temp] = true
    }
    /*
    #1. states/ subproblems
    dp[i][j] = i돌에서 가속도가 j일때 최소 점프 횟수
     */
    val dp = Array(n+1) {IntArray(n+1) {0} }
    for(i in 1 .. n) {

    }
}