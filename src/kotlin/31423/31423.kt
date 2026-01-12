fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()

    val str = Array(n) { "" }
    val parent = IntArray(n) { it }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    for (i in 0 until n) {
        str[i] = br.readLine()
    }
    fun find(x: Int): Int {
        if (x != parent[x]) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }
    for (i in 0 until n - 1) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        graph[u - 1].add(v - 1)
        parent[v - 1] = find(u - 1)
    }
    fun dfs(n: Int) {
        bw.write(str[n])
        for (nei in graph[n]) {
            dfs(nei)
        }
    }
    
    val temp = parent.find{parent[it]==it}
    dfs(temp!!)
    bw.flush()
}