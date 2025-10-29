import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n =br.readLine().toInt()
    val dangerX1 = IntArray(n)
    val dangerY1 = IntArray(n)
    val dangerX2 = IntArray(n)
    val dangerY2 = IntArray(n)
    for(i in 0 until n) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
        dangerX1[i] = x1
        dangerY1[i] = y1
        dangerX2[i] = x2
        dangerY2[i] = y2
    }
    val m = br.readLine().toInt()
    val deathX1 = IntArray(m)
    val deathY1 = IntArray(m)
    val deathX2 = IntArray(m)
    val deathY2 = IntArray(m)
    for(i in 0 until m) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
        deathX1[i] = x1
        deathY1[i] = y1
        deathX2[i] = x2
        deathY2[i] = y2
    }
    val dx = intArrayOf(0, -1, 0, 1)
    val dy = intArrayOf(1, 0, -1, 0)
    val queue = PriorityQueue<Pair<Pair<Int, Int>>, Int>
}