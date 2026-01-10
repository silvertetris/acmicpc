import java.util.LinkedList
import java.util.Queue

fun main() {
    val br= System.`in`.bufferedReader()
    val n =br.readLine().toInt()
    val p = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val graph = Array(n+1) {mutableListOf<Int>()}
    for(i in 0 until n-1) {
        graph[i+1].add(p[i])
        graph[p[i]].add(i+1)
    }

    /*
    리프 노드 안되고
    깊이가 2이상인거만
     */
    var cnt = 1
    val visited = BooleanArray(n+1) {false}
    queue.add(1 to 1)
    visited[1] = true
    while(queue.isNotEmpty()) {
        val size = queue.size

        repeat(size) {
            val(x, y) = queue.poll()
            if(y>2 && x!=1 && graph[x].size!=1) cnt++
            for(i in graph[x]) {
                if(!visited[i]) {
                    visited[i] = true
                    queue.add(i to y+1)
                }
            }
        }
    }
    print(cnt)
}