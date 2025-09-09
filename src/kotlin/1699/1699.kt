import kotlin.math.pow

fun main() {
    val n = readln().toInt()
    //최대 316까지
    val dp = IntArray(n+1) {Int.MAX_VALUE-100_000}
    val square = IntArray(n.toDouble().pow(0.5).toInt()+1) {0}
    for(i in 0 until square.size) {
        square[i] = i*i
    }
    dp[1] = 1
    for(i in 2..n) {
        for(j in 1..square.size) {
            if(i >= square[j]) {
                dp[i] = minOf()
            }
        }
    }
}