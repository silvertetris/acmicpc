import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val(n, m)  = br.readLine().split(" ").map { it.toInt() }
    val chess = Array(n) { IntArray(m) { 0 } }
    for(i in 0 until n) {
        chess[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val dx = intArrayOf(0, -1, 0, 1)
    val dy = intArrayOf(1, 0, -1, 0)
    fun bfs (start:Int) {
        val dist = Array(n) {IntArray(m) {-1} }
        val queue: Queue<IntArray> = LinkedList()
    }
}