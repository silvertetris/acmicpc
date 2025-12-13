fun main() {
    val br = System.`in`.bufferedReader()
    val(n, m) = br.readLine().split(" ").map { it.toInt() }
    val parent = IntArray(n+1) {it}
    val rank = IntArray(n+1) {0}
    fun find (x:Int) :Int {
        if(parent[x]!=x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }
    var cnt = 0
    /*
    아 사이클이 되면 안됨.
    일단 주어진 데이터에서 사이클이 생길 수 있음 그니까 최초 유니온시킬때 같은 루트면 끊어내는 연산을 해야함 -> 문제 읽기 (두 뉴련을 연결하거나 끊어내는 연산하면 cnt ++)
     */
    fun union(a:Int, b:Int) {
        val ra = find(a)
        val rb = find(b)
        if(ra==rb) {
            cnt++
            return
        }
        else if(rank[ra]<rank[rb]) {
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
    repeat(m) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        union(u, v)
    }
    /*
    찾아야하는 건 root종류가 몇개냐? 어차피 다 통합됐는데. -> 종류가 몇개인지 세는게 맞다
    그리고 사이클을 만들면 안됨 -> 자기자신인거 하나는 뺴야함 종류 수에서
     */
    val set = mutableSetOf<Int>()
    for(i in 1.. n) {
        set.add(find(i))
    }
    cnt+=set.size
    print(cnt-1)
}