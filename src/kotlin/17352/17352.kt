fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val parent = IntArray(n+1) {it}
    val rank = IntArray(n+1) {0}
    fun find(x:Int) :Int {
        if(parent[x]!=x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }
    fun union(a:Int, b:Int) {
        val ra = find(a)
        val rb = find(b)
        if(ra == rb) return
        else if(rank[ra] < rank[rb]) {
            parent[ra] = rb
        }
        else if(rank[ra]>rank[rb]) {
            parent[rb] = ra
        }
        else {
            parent[ra] = rb
            rank[rb]++
        }
    }
    repeat(n-2) {
        val (u, v) = br.readLine().split(" ").map{it.toInt()}
        union(u, v)
    }
    if(n==2) {
        print("1 2")
        return
    } else {
        val temp = find(1)
        for(i in 1.. n) {
            if(temp!= find(i)) {
                print("$temp ${find(i)}")
                return
            }
        }
    }
}