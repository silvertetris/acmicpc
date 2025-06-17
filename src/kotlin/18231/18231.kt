fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val adj = Array(n+1) {mutableListOf<Int> ()}
    for(i in 0 until m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        adj[temp[0]].add(temp[1])
        adj[temp[1]].add(temp[0])
    }
    val k = br.readLine().toInt()
    val p = br.readLine().split(" ").map { it.toInt() }.toIntArray()

}