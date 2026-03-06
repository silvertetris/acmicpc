fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = LongArray(60 * 60 * 24 + 1) { 0 }
    fun change(s: String): Pair<Int, Int> {
        val line = s.split(" - ")
        val start = line[0].split(":").map { it.toInt() }
        val end = line[1].split(":").map { it.toInt() }
        return start[0] * 3600 + start[1] * 60 + start[2] to end[0] * 3600 + end[1] * 60 + end[2]
    }

    repeat(n) {
        val s = br.readLine()
        val (start, end) = change(s)
    }
}