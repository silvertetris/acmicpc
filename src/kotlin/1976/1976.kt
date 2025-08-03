fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    //문제 제대로 읽기 -> 경로 통해서 갈 수 있으니까 그냥 어떻게든 이어져 있으면 방문 가능함
    val parent = IntArray( n+1) {it}
    val rank = IntArray(n+1) {0}
    fun find(x:Int):Int {
        if(x!=parent[x]) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }
    fun union(a:Int, b:Int) {
        val ra = find(a)
        val rb = find(b)
        if(ra==rb) {
            return
        }
        else if(rank[ra]<rank[rb]) {
            parent[ra] = rb
        }
        else if(rank[ra]>rank[rb]) {
            parent[rb] = ra
        } else {
            parent[ra] = rb
            rank[rb]++
        }
    }
    for(i in 1.. n) {
        val temp = br.readLine().split(" ").map{it.toInt()}.toIntArray()
        for(j in 0 until n) {
            if(temp[j] == 1) {
                union(i, j+1)
            }
        }
    }
    val seq = br.readLine().split(" ").map{it.toInt()}.toIntArray()
    val temp = find(seq[0])
    for(i in 1 until m) {
        if(find(seq[i]) != temp) {
            print("NO")
            return
        }
    }
    print("YES")
}