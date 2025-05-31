package kotlin

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    var result:ArrayList<Int> = ArrayList<Int>()
    while(true) {
        val x = sc.nextInt()
        val y = sc.nextInt()
        sc.nextLine()
        val arr:Array<Array<Int>> = Array(y) {Array(x) {0} }
        for(i in 0 until y) {
            arr[i]=sc.nextLine().split(" ").map { it.toInt() }.toTypedArray()
        }
        for(i in arr.indices-1) {
            for(j in arr[i].indices-1) {
                arr[i].min()
            }
        }

    }
}