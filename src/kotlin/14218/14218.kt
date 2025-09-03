fun main() {
    val br =System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val adj = Array(n+1) {mutableListOf<Int>()}
    for(i in 0 until m) {
        val(u, v) = br.readLine().split(" ").map { it.toInt() }
        adj[u].add(v)
        adj[v].add(u)
    }
    val q = br.readLine().toInt()

}