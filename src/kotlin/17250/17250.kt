fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val planets = LongArray(n+1) {0}
    for(i in 1..n) {
        planets[i] = br.readLine().toLong()
    }
    val parent = IntArray(n+1) {it}
    val rank = IntArray(n+1) {0}
    fun find(x:Int) :Int {
        if(parent[x]!=x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }
    fun union(a:Int , b:Int): Boolean {
        val ra = find(a)
        val rb = find(b)
        if(ra == rb) return false
        if(rank[ra]<rank[rb]) {
            parent[ra] = rb
            planets[rb] += planets[ra]
        }
        else if(rank[ra]>rank[rb]) {
            parent[rb] = ra
            planets[ra] += planets[rb]
        }
        else {
            parent[rb] = ra
            planets[ra] += planets[rb]
            rank[ra]++
        }
        return true
    }

    repeat(m) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        val flag = union(u, v)
        if(!flag){
            bw.write("${planets[parent[u]]}\n")
        } else {
            bw.write("${maxOf(planets[parent[u]], planets[parent[v]])}\n")
        }
    }
    bw.flush()
    bw.close()
}