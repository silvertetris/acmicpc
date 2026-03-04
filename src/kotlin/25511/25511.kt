fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val parents = IntArray(n) {it}
    val adj = Array(n) {mutableListOf<Int>()}
    repeat(n-1) {
        val(p, c) = br.readLine().split(" ").map { it.toInt() }
        parents[c] = p
        adj[p].add(c)
    }
    val order = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var idx = 0
    for(i in order) {
        if(order[i] ==k) {
            idx = i
            break
        }
    }
    fun find(x:Int) :Int{
        if(x!=parents[x]) parents[x] = find(parents[x])
        return parents[x]
    }
    var ans = 0
    val visited = BooleanArray(n) {false}
    fun dfs(x:Int, depth:Int)  {
        visited[x] = true

        if(x==idx) {
            ans = depth
            return
        }
        for(i in adj[x]) {
            if(!visited[i]) dfs(i, depth+1)
        }
    }
    dfs(find(idx), 0)
    print(ans)
}