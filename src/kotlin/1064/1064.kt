

import kotlin.math.pow

fun main() {
    val input = readln().split(" ").map { it.toDouble() }
    val xa = input[0]
    val ya = input[1]
    val xb = input[2]
    val yb = input[3]
    val xc = input[4]
    val yc = input[5]
    val atob = (xa-xb).pow(2) + (ya-yb).pow(2)
    val btoc = (xb-xc).pow(2) + (yb-yc).pow(2)
    val atoc = (xc-xa).pow(2) + (yc-ya).pow(2)
    if(atob==atoc || atob==btoc|| atoc==btoc) {
        print(-1)
        return
    }
    
}