package kotlin.`12932`

import java.util.*
import kotlin.math.abs

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextLine().toInt()
    val song = IntArray(n+1)
    for(i in 1 .. n) {
        song[i] = sc.nextInt()
    }
    val dp = Array(n) {IntArray(n) {-1} }
    fun recur(num1:Int, num2:Int):Int {
        if(num1 == n || num2 ==n) {
            return 0
        }
        if(dp[num1][num2] != -1) {
            return dp[num1][num2]
        }
        val p = maxOf(num1, num2) +1
        dp[num1][num2] = minOf(recur(p, num2) + (if(num1>0)abs(song[p] - song[num1]) else 0), recur(num1, p)+if(num2>0)abs(song[p] - song[num2])else 0)
        return dp[num1][num2]
    }

    print(recur(0,0))
}
