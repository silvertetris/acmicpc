fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val parent = IntArray(n + 1) { it }
    val rank = IntArray(n + 1) { 0 }
    fun find(x: Int): Int {
        if (x != parent[x]) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(a: Int, b: Int) {
        val ra = find(a)
        val rb = find(b)
        if (ra == rb) return
        else if (rank[ra] < rank[rb]) {
            parent[ra] = rb
        } else if (rank[ra] > rank[rb]) {
            parent[rb] = ra
        } else {
            parent[ra] = rb
            rank[rb]++
        }
    }
    for (i in 0 until m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        union(a, b)
    }
    val money = IntArray(n+1) {Int.MAX_VALUE}
    var result = 0
    for(i in 1 .. n) {
        val temp = find(i)//아니 멍청아 parent는 상위노드고 루트가 아니잖아
        money[temp] = minOf(a[i-1], money[temp])
    }
    for(i in 1 .. n) {
        if(money[i]!=Int.MAX_VALUE) {
            result+= money[i]
        }
    }
    if(result>k) {
        print("Oh no")
    } else {
        print(result)
    }
}