fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val adj = Array(n+1) {mutableListOf<Pair<Int, Int>>() } //dest, dist

    for(i in 1.. n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        for(j in 0 until n) {
            if(j==i-1 || temp[j]==0) continue
            else {
                adj[i].add(j+1 to temp[j])
            }
        }
    }

    //1
    val dp = Array(n+1) {Array(n+1) {Int.MAX_VALUE} }

    for(i in 1.. n) {
        dp[i][i] = 0
    }
    val visited = BooleanArray(n+1) {false}
    fun dfs(n: Int, distance:Int) { // dist를 계속 더함
        visited[n] = true
        for(neighbor in adj[n]) {
            if(!visited[neighbor.first]) {
                if(neighbor.second -distance <0) {
                    continue
                }
                dp[n][neighbor.first] = minOf(dp[n][neighbor.first], dp[n][neighbor.first]-distance + neighbor.second)
            }
        }
    }

    /*
    1. graph dfs dp??
    2. graph bfs dp??
     */

    /*
    #1. states/ subproblems
    dp[i][j] = min dist of i to j (indices)

     */
    //#2. Base Cases -> dp[i][j] = 0 if i==j
    /*
    ex1) dfs iteration -> from 1 to any nodes that is not visited
    ex2 bfs iteration -> from 1 to entire nodes -> find minimum path -> 일방통행 감지가 가능한가??
     */


}