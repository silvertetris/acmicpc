fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n+1) {IntArray(m+1) {0} }
    for(i in 1 .. n) {
        arr[i] = intArrayOf(0) + br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    br.close()
    val preArr = Array(n) {IntArray(m)}
}