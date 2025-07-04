fun main() {
    val br = System.`in`.bufferedReader()
    val(v, e) = br.readLine().split(" ").map { it.toInt() }
    val adj = Array(e){ Pair(0 to 0 , 0)}
    for(i in 0 until e) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        adj[i] = Pair(temp[0] to temp[1], temp[2])
    }
    adj.sortBy { it.second }
    val parent = IntArray(v+1) {it}
    fun find(x:Int) :Int{ //가장위 트리 찾기 -> 깊이
        if(parent[x]!=x) parent[x] = find(parent[x])
        return parent[x]
    }
    fun union(a:Int , b:Int): Boolean{
        val ra = find(a)
        val rb = find(b)
        if(ra == rb)return false // 서로 부모가 같으면 무한 굴레
        parent[rb] = ra
        return true
    }

    var result = 0
    var cnt = 0
    for(i in adj) {
        val(u, vv) = i.first
        if(union(u,vv)) {
            result+=i.second
            if(++cnt == v-1) break
        }
    }

    print(result)
}