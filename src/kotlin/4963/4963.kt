import java.util.LinkedList


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    while (true) {
        val (w, h) = br.readLine().split(' ').map { it.toInt() }
        if (w == 0 && h == 0) break
        val adj = Array(h) { IntArray(w) }
        for (i in 0 until h) {
            adj[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        }
        val dx = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
        val dy = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
        val visited = Array(h) { BooleanArray(w) { false } }
        fun bfs(a: Int, b:Int) {
            val queue = LinkedList<Pair<Int,  Int>>()
            queue.push(a to b)
            while(!queue.isEmpty()) {
                val cur = queue.poll()
                for(i in 0 until 8) {
                    val nextRow = cur.first + dy[i]
                    val nextColumn = cur.second + dx[i]
                    if(nextRow in 0 until h && nextColumn in 0 until w && !visited[nextRow][nextColumn]&& adj[nextRow][nextColumn] == 1) {
                        visited[nextRow][nextColumn] = true
                        queue.push(nextRow to nextColumn)
                    }
                }
            }
        }
        var count = 0
        for(i in 0 until h) {
            for(j in 0 until w) {
                if(!visited[i][j]&& adj[i][j] ==1) {
                    bfs(i, j)
                    count++
                }
            }
        }
        bw.write("${count}\n")
    }
    bw.flush()
    bw.close()
}