

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val card = br.readLine().split(" ").map { it.toInt() }
        val dp = Array(n + 1) { IntArray(2) { 0 } }
        var ans = 0
        var l = 0
        var r = n - 1
        while(l<=r) {

        }
        bw.write("$ans\n")
    }
    bw.flush()
    bw.close()
}