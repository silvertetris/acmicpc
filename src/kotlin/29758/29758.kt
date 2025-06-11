import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        //뒤수가 앞수의 제곱을 넘으면 안됨

        val(n, l) = br.readLine().split(" ").map { it.toInt() }
        val dp = Array(l+1) {IntArray(n+1)}
        dp[0][0] = 1
        for(i in 1 until l) {
            for(j in 0 until n) {

            }
        }
    }
}