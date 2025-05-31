package kotlin.`25195`

fun main() {
    val br = System.`in`.bufferedReader()
    val(n ,m) = br.readLine().split(" ").map { it.toInt() }
    val adj = Array(n+1) {mutableListOf<Int>()}
    for(i in 0 until m) {
        val(u, v) = br.readLine().split(" ").map { it.toInt() }
        adj[u].add(v)
    }
    val asdf= br.readLine()
    val s = br.readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(n+1)
    var bool = false
    fun dfs(idx:Int) {
        if(adj[idx].isEmpty()) {
            bool = true
            return
        }
        for(i in adj[idx]) {
            if(s.contains(i)) {
                visited[i] = true
                continue
            }
            if(!visited[i]) {
                visited[i] = true
                dfs(i)
            }

        }
    }
    dfs(1)
    if(s.contains(1)) bool = false
    print(if(bool) "yes" else "Yes")
}