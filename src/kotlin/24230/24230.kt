fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val c = br.readLine().split(" ").map { it.toInt()}
    val graph= Array(n+1) {mutableListOf<Int>()}
    repeat(n-1) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }
    /*
    분리집합? 20만개라 에바
    dfs가 맞는데 무조건
    색의 기준이 모호함
    그냥 위로만 연결안되게 해야하나?
    루트노트가 뭔지 어떻게 알지?
    루트노드를 신경쓰지 않아도 되는게 어차피 visited가 있음
    -> 그러면 역류 색만 보면 됨 ->어차피 연결된 모든곳을 봄 -> 다른색일떄의 사이클 봄

    루트가 0이면 편함 아니면 어차피 무조건 +1임
    -> 또 하얀색은 칠하면 안됨 . 0인거
     */
    val visited = BooleanArray(n+1) {false}
    var cnt = 0
    fun dfs(x:Int, u:Int) {
        visited[x] = true
        if(c[x-1]!=u&& c[x-1]!=0) cnt++
        for(nei in graph[x]) {
            if(!visited[nei]) {
                dfs(nei, c[x-1])
            }
        }
    }
    dfs(1, 0)
    print(cnt)
}