import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val str = StringTokenizer(br.readLine())
    /*
    ID의 약수중 1제외
    그니까 가장 많이 전파 가능한놈
    작은 수에서 큰수 배수 일치하는 놈의 개수
    rank 1부터 시작 없는건 그냥 0임
    소인수 분해 해서, 그냥 다 유니온
    제일큰 랭크 -> 전파된 놈의 개수
     */
    val parent = IntArray(1_000_001) {it}
    val rank = IntArray(1_000_001) {0}
    fun find(x:Int):Int {
        if(parent[x]==x) {
            return x
        }
        parent[x] = find(parent[x])
        return parent[x]
    }
    fun union(a:Int, b:Int) {
        val ra = find(a)
        val rb = find(b)
        if(ra==rb) {
            return
        }
        else if(rank[ra]<rank[rb]) {
            parent[ra]=rb
            rank[rb]+=rank[ra]
            rank[ra]=0
        }
        else if(rank[ra]>rank[rb]) {
            parent[rb] = ra
            rank[ra]+=rank[rb]
            rank[rb]=0
        } else {
            parent[rb] = ra
            rank[ra]+=rank[rb]
            rank[rb]=0
        }
    }
    val a = IntArray(n)
    for(i in 0 until n) {
        a[i] = str.nextToken().toInt()
        rank[a[i]]++
    }
    val max = a[n-1]
    val minimize = IntArray(1_000_001) {0}
    for(i in 2.. 1_000_000) {
        if(minimize[i]==0) {
            for(j in i..1_000_000 step i) {
                if(minimize[j]==0) {
                    minimize[j] = i
                }
            }
        }
    }
    for(i in 0 until n) {
        var temp = a[i]
        while (temp > 1) {
            val p = minimize[temp]
            union(a[i], p)
            while (temp % p == 0) {
                temp /= p
            }
        }
    }
    print(rank.max())
}