package kotlin.`23255`

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val adj = Array(n+1) {mutableListOf<Int>()}
    val answer = IntArray(n+1) {0}
    val visited = BooleanArray(n+1) {false}
    for(i in 0 until m) {
        val(a, b) = br.readLine().split(" ").map { it.toInt() }
        adj[a].add(b)
        adj[b].add(a)
    }
    for(i in 1.. n) {
        visited.fill(false)
        for(j in adj[i]) { //해당 건물과 구름 다리 이어진 놈들
            visited[answer[j]] = true //원래 이어진 놈들 (겹치는 놈들) 을 체크함.
        }
        var temp = 1
        while(visited[temp])temp++ //그리디식으로 처음부터 계속 확인해서 사전순으로 번호를 매김
        answer[i] = temp
    }
    for(i in 1 .. n) {
        print("${answer[i]} ")
    }
}