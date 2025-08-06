fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
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
        else if(rank[ra]<rank[rb]) {
            parent[ra] = rb
        } else if(rank[ra]>rank[rb])
            parent[rb] = ra
        else {
            parent[rb] = ra
            rank[ra]++
        }
    }
    if(m==0) {
        print(n)
        return
    }
    val sweep = mutableListOf<Pair<Int, Int>>()

    repeat(m) {
        val(u, v) = br.readLine().split(" ").map {it.toInt()}
        sweep.add(u to v)
    }
    sweep.sortWith(compareBy({it.first}, {it.second}))
    var l = sweep[0].first
    var r = sweep[0].second
    val gap = mutableListOf<Pair<Int, Int>>()
    for(i in 1 until m) {
        if(sweep[i].first in l..r) {
            r = maxOf(sweep[i].second, r)
        } else {
            gap.add(l to r)
            l = sweep[i].first
            r = sweep[i].second
        }
    }
    gap.add(l to r)
    for(i in gap.indices) {
        for(j in gap[i].first .. gap[i].second) {
            union(gap[i].first, j)
        }
    }

    val temp = parent.toMutableSet()
    print(temp.size-1)
}