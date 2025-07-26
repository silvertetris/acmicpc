fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val parent = IntArray(n + 1) { it }
    val rank = IntArray(n + 1) { 0 }
    fun find(n: Int): Int {
        if (parent[n] != n) {
            parent[n] = find(parent[n])
        }
        return parent[n]
    }

    fun union(u: Int, v: Int) {
        val ru = find(u)
        val rv = find(v)
        if (ru == rv) return
        else if (rank[ru] > rank[rv]) {
            parent[rv] = ru
        } else if (rank[ru] < rank[rv]) {
            parent[ru] = rv
        } else {
            parent[ru] = rv
            rank[rv]++
        }
    }
    for (i in 0 until m) {
        val (op, a, b) = br.readLine().split(" ").map { it.toInt() }
        if (op == 0) {
            union(a, b)
        } else {
            if (find(a) == find(b)) {
                bw.write("YES\n")
            } else {
                bw.write("NO\n")
            }
        }
    }
    bw.flush()
    bw.close()
}