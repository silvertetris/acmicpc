import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val str11 = StringTokenizer(br.readLine())
    val n = str11.nextToken().toInt()
    val m = str11.nextToken().toInt()

    val h = IntArray(n + 1)
    val str = StringTokenizer(br.readLine())
    for (i in 1..n) {
        h[i] = str.nextToken().toInt()
    }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    for (i in 0 until m) {
        val str3 = StringTokenizer(br.readLine())
        if (str3.hasMoreTokens()) {
            val u = str3.nextToken().toInt()
            val v = str3.nextToken().toInt()
            graph[u].add(v)
            graph[v].add(u)
        }
    }
    val k = br.readLine().toInt()
    val str2 = StringTokenizer(br.readLine())
    val isStuck = BooleanArray(n + 1) { false }
    var ans = true
    fun dfs(x: Int) {//그니까 안전한걸 전파 -> 안전한 필요조건 확정적으로 안전하고 낮은애가 불안전하고 높은애한테 전파 가능
        isStuck[x] = true
        for (nei in graph[x]) {
            if (!isStuck[nei] && h[x] < h[nei]) { //지금 들고있는 애가 낮고 -> 높은애를 찾음 (발상의 전환 거꾸로 생각하기)
                isStuck[nei] = true
                dfs(nei)
            }
        }
    }

    for (i in 0 until k) {//얘먼저 전파
        val temp = str2.nextToken().toInt()
        if (!isStuck[temp]) {
            dfs(temp)
        }
    }
    for (i in 1..n) {
        if (!isStuck[i]) {
            ans = false
            break
        }
    }
    if (ans) {
        print("no flood")
    } else print("flood")
}