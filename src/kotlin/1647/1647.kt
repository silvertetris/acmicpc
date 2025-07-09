fun main() {
    val br = System.`in`.bufferedReader()
    val(n, m) = br.readLine().split(" ").map { it.toInt() }
    val adj = Array(m) {Pair(0 to 0, 0)}
    for(i in 0 until m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        adj[i] = Pair(temp[0] to temp[1], temp[2])
    }
    adj.sortBy { it.second }
    val parent = IntArray(n+1) {it}
    fun find(x:Int) :Int{
        if(parent[x]!=x) parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(a:Int , b:Int): Boolean{
        val ra = find(a)
        val rb = find(b)
        if(ra == rb)return false
        parent[rb] = ra
        return true
    }
    //최소 구하고 제일 큰거 싹둑
    var result = 0
    var max = 0
    for(i in adj) {
        if(union(i.first.first, i.first.second)) {
            result+=i.second
            max = maxOf(max, i.second)
        }
    }
    print(result-max)
}