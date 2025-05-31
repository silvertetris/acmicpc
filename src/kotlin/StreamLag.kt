package kotlin

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    var arr:Array<Pair<Int, Int>> = Array(n) { Pair<Int, Int>(0,0) }
    var max = 0
    var result =0
    for( i in 0 until n) {
        val first = sc.nextInt() // 시간대
        val second = sc.nextInt() // 패킷 넘버
        arr[i]=Pair(second, first) //n번째 패킷, 들어오는 초
        max = maxOf(max, first)
    }
    arr.sortBy { it.first }
    var temp = 0
    for(i in 1 .. max) {
        if(arr[temp].second==i) {
            temp++
            continue
        }
        else if(arr[temp].second> i) result++
        else temp++
    }
    println(result)
}