fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }//시리얼 넘버 개수, 해당 수의 배수
        val s = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        /*
        #1. states / subproblems
        dp[i][j] = i인덱스에서 합이 j 일 때 최대 선택 개수
         */

    }
}