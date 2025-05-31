package kotlin.`1932`

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = IntArray(n+1)
    val arr = Array(n) {IntArray(n) {0} }
    for(i in 0 until n) {
        arr[i] = br.readLine().split(" ").map{ it.toInt() }.toIntArray()
    }
    for(i in n-1 downTo 0) {
        for(j in 0 until i) {
            arr[i-1][j] +=maxOf(arr[i][j], arr[i][j+1])
        }
    }
    print(arr[0][0])
}