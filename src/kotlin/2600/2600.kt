fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (b1, b2, b3) = br.readLine().split(" ").map { it.toInt() }
    val dp = BooleanArray(531) { false }
    repeat(5) {
        val (k1, k2) = br.readLine().split(" ").map { it.toInt() }
    }
}