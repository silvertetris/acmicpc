fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n+1) { mutableListOf<Int>() }
    repeat(n-1) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        arr[u].add(v)
        arr[v].add(u)
    }
    /*
    성원이 먼저 시작
    -> 아 그냥 홀수 짝수 맞추고 결과값보고 바꾸기
    -> 리프 홀짝이 아니라 리프의 거리 홀짝합을 봐야함
     */

    val visited = BooleanArray(n+1) {false}
    var cnt = 0
    fun dfs(n:Int, d:Int) {
        visited[n] = true
        var flag = false
        for(neighbour in arr[n]) {
            if(!visited[neighbour]){
                flag = true
                dfs(neighbour, d+1)
            }
        }
        if(!flag) {
            cnt+=d
        }
    }
    dfs(1, 0)
    if(cnt%2!=0) {
        print("Yes")
    } else {
        print("No")
    }
}