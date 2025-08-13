fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, r, q) = br.readLine().split(" ").map { it.toInt() }
    val adj = Array(n+1) {mutableListOf<Int>()}
    repeat(n-1) {
        val(u, v) = br.readLine().split(" ").map { it.toInt() }
        adj[u].add(v)
        adj[v].add(u)
    }
    val dp = IntArray(n+1) {0}//dp[i] = i가 루트일때 서브트리 정점 수
    fun dfs(x:Int, parent:Int) {
        dp[x] = 1
        for(u in adj[x]) {
            if(u==parent) continue
            dfs(u, x)//인접, 역류방지
            dp[x]+=dp[u]//각 간선의 수는 1이니까 부모칸에 더함
        }
    }
    dfs(r, 0)//얘가 루트니까 0으로 해도 됨 -> 부모가 없음
    repeat(q) {
        val u = br.readLine().toInt()
        bw.write("${dp[u]}\n")
    }
    bw.flush()
}