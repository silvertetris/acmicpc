fun main() {
    val br = System.`in`.bufferedReader()
    val(t, w) = br.readLine().split(" ").map { it.toInt() }
    val tree = IntArray(t)
    for(i in 0 until t) {
        tree[i] = br.readLine().toInt()
    }
    /*
     #1. states / subproblems
     dp[i][j] = i번째 턴에 j번 움직였을 때
     */
    val dp = Array(t) {IntArray(w) {0} }
    dp[0][0] = if(tree[0] ==1) 1 else 0
    for(i in 1 until t) {
        
    }
}