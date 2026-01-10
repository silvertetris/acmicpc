import java.util.Deque
import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val deque: Deque<Pair<Int, Int>> = LinkedList()
    val visited = BooleanArray(n+1)
    var cnt = 0
    visited[0] = true
    deque.add(0 to 0)
    while(deque.isNotEmpty()) {
        val (x, y) = deque.poll()
        if(x<n && !visited[x+1]) {
            deque.add(x+1 to y+1)
        }
    }
}