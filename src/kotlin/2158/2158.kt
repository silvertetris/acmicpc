import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (v, r, c) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(r) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val dist = Array(r) { FloatArray(c) { Float.POSITIVE_INFINITY} }
    dist[0][0] = 0f

    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
}