package kotlin.`11261`

import java.util.Scanner

fun main() {
    val sc= Scanner(System.`in`)
    val bw = System.`out`.bufferedWriter()
    val t = sc.nextInt()
    sc.nextLine()
    repeat(t){
        val n = sc.nextLine().toInt()
        val w = sc.nextLine().toInt()
        val weight = IntArray(n) {0}
        val value = IntArray(n) {0}
        for(i in 0 until n) {
            weight[i] = sc.nextInt()
        }
        sc.nextLine()
        for(i in 0 until n) {
            value[i] = sc.nextInt()
        }
        sc.nextLine()

        val dp = Array(n+1){Array(w+1){0}}
        for(i in 1..n){
            for(j in 1..w){
                if(j<weight[i-1]){
                    dp[i][j] = dp[i-1][j]
                }else{
                    dp[i][j] = maxOf(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1])
                }
            }
        }
        bw.write("${dp[n][w]}\n")
    }
    bw.flush()
    bw.close()
}