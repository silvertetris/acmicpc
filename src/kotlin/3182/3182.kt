package kotlin.`3182`

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val graph: MutableList<MutableList<Int>> = MutableList(n + 1) { mutableListOf() }

    for(i in 1..n) {
        graph[i].add(br.readLine().toInt()) //unweighted, directed graph
    }
    fun dfs(v: Int, visited: BooleanArray) {
        visited[v] = true
        for (i in graph[v].indices) {
            if(!visited[graph[v][i]]) {
                dfs(graph[v][i], visited)
            }
        }
    }

    var answer = 0
    var temp = 0
    for(i in 1 .. n ) {
        val visited = BooleanArray(n+1) {false} //internal booleanArray -> 최대 거리를 찾기 위해
        dfs(i, visited)
        var temp1 = 0
        for(i in visited) {
            if(i) temp1++
        }
        if(temp<temp1) {
            answer = i
            temp = temp1
        }
    }
    print(answer)
}
