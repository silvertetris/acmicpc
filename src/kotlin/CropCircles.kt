package kotlin

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    var n = sc.nextInt()
    var array = Array(n) { Array(4) { 0 } } //3차원 배열 선언
    for (i in 0 until n) {
        for (j in 0 until 3) {
            array[i][j] = sc.nextInt()
        }
    }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i == j) continue
            val x_sub = Math.abs(array[i][0] - array[j][0])
            val y_sub = Math.abs(array[i][1] - array[j][1])
            val root_val = Math.sqrt(Math.pow(x_sub.toDouble(), 2.0) + Math.pow(y_sub.toDouble(),2.0))
            if(root_val<(array[i][2]+array[j][2])) {
                array[i][3]++
            }
        }
    }
    for(i in 0 until n) {
        println(array[i][3])
    }


}