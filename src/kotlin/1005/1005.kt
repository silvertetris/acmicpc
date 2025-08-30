import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val(n, k) = br.readLine().split(" ").map { it.toInt() }
        val indegree = IntArray(n+1) {0}
        val d = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        val adj = Array(n+1) {mutableListOf<Int>()}
        repeat(k) {
            val(x, y) = br.readLine().split(" ").map { it.toInt() }
            adj[x].add(y)//x 짓고 y 짓기
            indegree[y]++
        }
        val w = br.readLine().toInt()
        val dp = IntArray(n+1) {0}
        val q: Queue<Int> = LinkedList()
        for(i in 1..n) {
            if(indegree[i]==0) {
                q.add(i)
                dp[i] = d[i-1]
            }
        }
        while(q.isNotEmpty()) {
            val cur = q.poll()
            for(nei in adj[cur]) {
                indegree[nei]--
                dp[nei] = maxOf(dp[nei], dp[cur] + d[nei-1])
                if(indegree[nei]==0) {
                    q.add(nei)
                }
            }
        }
        bw.write("${dp[w]}\n")
    }
    bw.flush()
    bw.close()
}