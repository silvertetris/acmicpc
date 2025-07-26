fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val parent = IntArray(100_000_1) { it }
    val rank = IntArray(1000_001) { 0 }
    fun find(x: Int): Int {
        if (x != parent[x]) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(a: Int, b: Int) {
        val ra = find(a)
        val rb = find(b)
        if(ra == rb) return
        if(rank[ra]<rank[rb]) {
            parent[ra] = rb
        } else if(rank[ra]>rank[rb]) {
            parent[rb] = ra
        } else{
            parent[rb] = ra
            rank[ra]++
        }
    }
    repeat(n) {
        val temp = br.readLine().split(" ")
        if(temp[0] == "I"){
            union(temp[1].toInt(), temp[2].toInt())
        } else {
            bw.write("${rank[temp[1].toInt()]}\n")
        }
    }
    bw.flush()
    bw.close()
}