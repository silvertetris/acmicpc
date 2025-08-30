import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val indegree = IntArray(n+1) {0}
    val adj = Array(n+1) {mutableListOf<Int>()}
    val time = IntArray(n+1) {0}
    for(i in 1 .. n) {
        val line = br.readLine().split(" ").map{it.toInt()}.toIntArray()
        time[i] = line[0]
        for(j in 0 until line[1]) {
            //이 다음 나오는게 먼저 되어야함
            adj[line[2+j]].add(i)
            indegree[i]++
        }
    }
    val q: Queue<Int> = LinkedList()
    val dp = IntArray(n+1) {0}
    for(i in 1..n) {//#2 Base Cases
        if(indegree[i] ==0) {
            dp[i] = time[i]
            q.add(i)
        }
    }

    while(q.isNotEmpty()) {
        val cur = q.poll()
        for(nei in adj[cur]) {
            dp[nei] = maxOf(dp[nei], dp[cur] + time[nei]) //#3. transition
            if(--indegree[nei] == 0) {
                q.add(nei)
            }
        }
    }
    //#4. final answer : 모든 작업
    print(dp.max())
}