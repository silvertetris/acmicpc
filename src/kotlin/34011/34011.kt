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
    이고 -> 원하는 횟수만큼 계속해서 이동할 수 있다는 거임 제동계수 의 배수
    그니까 2부터 ... N의 배수까지 이동할 수 있음
    근데 N거리만큼 이동하는건 현실적으로 불가능
    그니까 최대 n-2까지는 이동이됨 (리프제외니까)

     */
    val visited = BooleanArray(n+1) {false}
    var cnt = 1
    queue.add(1 to 1)
    visited[1] = true
    while(queue.isNotEmpty()) {
        val size = queue.size
        repeat(size) {
            val(x, y) = queue.poll()
            cnt = maxOf(cnt, y)
            for(i in graph[x]) {
                if(!visited[i]) {
                    visited[i] = true
                    queue.add(i to y+1)
                }
            }
        }
    }
    if(cnt<3) {
        print(1)
    }else {
        print(cnt-2)
    }
}