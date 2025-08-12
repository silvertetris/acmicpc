fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val parent = IntArray(n) {it}
    val rank = IntArray(n) {0}
    fun find(x:Int) :Int {
        if(parent[x]!=x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }
    fun union(a:Int, b:Int):Boolean {
        val ra = find(a)
        val rb = find(b)
        if(ra==rb){
            return true
        }
        else if(rank[ra]<rank[rb]) {
            parent[ra] = rb
        } else if(rank[ra]>rank[rb]) {
            parent[rb] = ra
        } else {
            parent[ra] = rb
            rank[rb]++
        }
        return false
    }

    repeat(m) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        val temp = union(u, v)
        if(temp) {
            print("${it+1}")
            return
        }
    }
    print(0)
}