fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val n = br.readLine().toInt()
    val arr1 = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val arr2 = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    //각 B, E가 몇인지 -> 최대값
    val dp = Array(n+1) {IntArray(n+1) {0} }
    /*
    #1. states/subproblems
    dp[i][j] = B가 i 고 E가 j 일때 곱 합의 최대 값
    연산을 일일히 바뀔때마다 하면 무조건 시간초과임

     */
}