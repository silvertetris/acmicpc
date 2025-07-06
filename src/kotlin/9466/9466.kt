fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    //결국 사이클 찾기 -> 사이클에 들지 못하는 애들 찾기

    repeat(t) {
        val n = br.readLine().toInt()
        val adj = IntArray(n + 1)
        val arr = br.readLine().split(" ").map { it.toInt() }
        val visited = BooleanArray(n + 1) { false }
        val cycle = BooleanArray(n + 1) { false }
        var cnt = 0
        fun dfs(now: Int, visited: BooleanArray,cycle: BooleanArray, adj: IntArray) {
            visited[now]  = true
            if(!visited[adj[now]]) {
                dfs(adj[now], visited, cycle, adj)
            }
            if(!cycle[adj[now]]) { //사이클까지 확인하면 tle뜰거 같음 -> 효율적이게 확인하는 방법?
                var temp = adj[now]//다음거
                cnt++
                while(temp != now) {//사이틀 확인하면 끝 -> cnt만큼 (사이클) 수 차감
                    temp = adj[temp]
                    cnt++
                }
            }
            cycle[now] = true
        }
        for (i in 1..n) {
            adj[i] = arr[i - 1]
        }
        for(i in 1 .. n) {
            if(!visited[i]) {
                dfs(i, visited, cycle, adj)
            }
        }
        bw.write("${n-cnt}\n")
    }
    bw.flush()
    bw.close()
}