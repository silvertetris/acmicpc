fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, q) = br.readLine().split(" ").map{it.toInt()}
    val m = IntArray(n+1) {0}
    val result = IntArray(n+1) {0}
    for(i in 1 .. n) {
        m[i] = br.readLine().toInt()
    }
    val parent = IntArray(n+1) {it}
    val rank = IntArray(n+1){0}
    fun find(x:Int) :Int {
        if(parent[x] != x) {
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
        } else if(rank[ra]>rank[rb]) {
            parent[rb] = ra
        } else {
            parent[ra] = rb
            rank[rb]++
        }
    }
    repeat(q) {
        val temp = br.readLine().split(" ").map{it.toInt()}
        var i = temp[1]
        if(temp[0] == 1) {//i번째 놈이 x 만큼 술을 가지고 i부터 n까지 의리게임 -> 자기가 최대까지 마시고 다음 넘김
            var x = temp[2]
            while(x > 0) {
                val j = find(i)
                if(j > n) break
                val can = m[j] - result[j]
                if(can > x) {
                    result[j] += x
                    break
                } else {
                    result[j] = m[j] //다맥임
                    x -= can
                    if(j < n) union(j, j + 1) else break
                    i = j + 1 //다음
                }
            }

        } else{
            bw.write("${result[i]}\n")
        }
    }
    bw.flush()
}