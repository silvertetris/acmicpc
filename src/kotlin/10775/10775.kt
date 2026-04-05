fun main() {
    val br = System.`in`.bufferedReader()
    val g = br.readLine().toInt()
    val p = br.readLine().toInt()
    val gates = IntArray(p)
    for(i in 0 until p) {
        gates[i] = br.readLine().toInt()
    }
    /*
    각 게이트 번호가 1부터 G까지 있는거임
주어지는건 각 비행기가 어디 게이트에 도킹할지에 대한 g[i]임

영구적으로 도킹
그니까 1..g[i] 중에 한 게이트에 i번째 비행기를 도킹시키는 것임
무조건 g[i]부터 채워야함 -> 그리디적 성질

최대 도킹 가능한 비행기
union - find??
부모를 바꾸기?
없으면 하나 줄여서 넣고?
만약 자식이 1 이면 멈추기?

1. root는 항상 1
1에다가 상위 애들을 닮 O(n^2)를 절대로 만들면 안됨

     */
    val parents = IntArray(g+1) {it}
    val rank = IntArray(g+1) {it}

    fun find(x:Int) :Int {
        if(parents[x] != x) {
            parents[x] = find(parents[x])
        }
        return parents[x]
    }

    fun union(a:Int, b:Int) {
        val ra = rank[a]
        val rb = rank[b]
        if(ra==rb) return

        else if(rank[ra]<rank[rb]) {
            parents[ra] = rb
        } else if(rank[rb]<rank[ra]) {
            parents[rb] = ra
        } else {
            parents[ra] = rb
            rank[rb]++
        }
    }

}