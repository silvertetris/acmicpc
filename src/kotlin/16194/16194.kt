fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val p = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp = Array(n+1) {IntArray(10000) {0} }

}