fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m, r) = br.readLine().split(" ").map { it.toInt() }
    val adj = Array(n+1) {mutableListOf<Int>()}
    val visited = IntArray(n+1) {0}
    repeat(m) {
        val(u, v) = br.readLine().split(" ").map { it.toInt() }
        adj[u].add(v)
        adj[v].add(u)
    }
    for(i in 1 ..n) {
        adj[i].sortDescending()
    }
    var cnt= 1

    fun dfs (x:Int) {
        visited[x] = cnt++
        for(nei in adj[x]) {
            if(visited[nei] == 0) {
                dfs(nei)
            }
        }
    }
    dfs(r)
    for(i in 1 .. n) {
        bw.write("${visited[i]}\n")
    }
    bw.flush()
    bw.close()
}
