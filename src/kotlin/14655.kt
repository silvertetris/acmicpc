

import java.util.*
import kotlin.math.abs

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    var result = 0
    repeat(n*2) {
        result += abs(sc.nextInt())
    }
    println(result)
}