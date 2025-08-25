fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val adj = Array(n+1) {mutableListOf<Int>()}

    val visited = IntArray(n+1) {0}
    var cnt = 1
    repeat(n-1) {
        val(u, v) = br.readLine().split(" ").map { it.toInt() }
        adj[u].add(v)
        adj[v].add(u)
    }
    val order = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    fun dfs(x:Int) {
        visited[x] = cnt++
        for(nei in adj[x]) {
            if(visited[nei] == 0) {
                dfs(nei)
            }
        }
    }
    dfs(1)
    for(i in 1..n) {
        if(visited[i] != order[i-1]) {
            print(0)
            return
        }
    }
    print(1)
}