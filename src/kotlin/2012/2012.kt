

import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = IntArray(n)
    for(i in 0 until n) {
        arr[i] = br.readLine().toInt()
    }
    arr.sort()
    var answer = 0L

    for(i in 0 until n) {
        answer += abs(arr[i] - (i+1))
    }
    print(answer)
}