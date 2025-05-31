package kotlin.`1240`

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val adj = Array(n+1) {mutableListOf<Pair<Int, Int>>()}
    val visited = BooleanArray(n+1)
    for(i in 0 until n-1) {
        val(a, b, c) = br.readLine().split(" ").map { it.toInt() }
        adj[a].add(b to c)
        adj[b].add(a to c)
    }
    val find = Array(m) {Pair(0, 0)}
    for(i in 0 until m) {
        val(a, b) = br.readLine().split(" ").map { it.toInt() }
        find[i] = a to b
    }
    fun dfs(start: Int, end:Int, cost: Int) {
        if(start == end) {
            bw.write("$cost\n")
            return
        }
        if(!visited[start]) {
            visited[start] = true
            for(neighbor in adj[start]) {
                dfs(neighbor.first, end, cost+neighbor.second)
            }
        }
    }
    for(i in 0 until m) {
        dfs(find[i].first, find[i].second, 0)
        visited.fill(false)
    }
    bw.flush()
    bw.close()
}