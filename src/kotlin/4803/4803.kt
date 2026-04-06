import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var case = 1
    while (true) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) {
            break
        }
        val graph = Array(n + 1) { mutableListOf<Int>() }
        repeat(m) {
            val str = StringTokenizer(br.readLine())
            val u = str.nextToken().toInt()
            val v = str.nextToken().toInt()
            graph[u].add(v)
            graph[v].add(u)
        }
        val visited = IntArray(n+1) {0}
        var temp = 1
        visited[0] = temp
        var flag = false
        fun dfs(x:Int, cost:Int, y:Int) {
            visited[x] = cost
            for(nei in graph[x]) {
                if(visited[nei]==cost && nei!=y) {
                    flag = true
                }
                if(visited[nei]==0) {
                    dfs(nei, cost, x)
                }
            }
        }

        var cnt = 0
        for (i in 1..n) {
            if (visited[i]<1) {
                dfs(i, temp, 0)
                temp++
                cnt++
                if(flag) {
                    cnt--
                    flag= false
                }
            }
        }
        if (cnt == 0) {
            bw.write("Case $case: No trees.\n")
        } else if(cnt==1) {
            bw.write("Case $case: There is one tree.\n")
        } else {
            bw.write("Case $case: A forest of $cnt trees.\n")
        }
        case++
    }
    bw.flush()
}