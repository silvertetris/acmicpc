fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val truth = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    truth.removeFirst()
    truth.toMutableSet()
    val adj = Array(n + 1) { mutableSetOf<Int>() }
    val party = Array(m) { mutableListOf<Int>() }
    for (i in 0 until m) {
        val temp = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        for (j in 1 until temp.size) {
            party[i].add(temp[j])
            for (k in j until temp.size) {
                if (truth.contains(temp[j]) || truth.contains(temp[k])) {
                    truth.add(temp[j])
                    truth.add(temp[k])
                }
                adj[temp[j]].add(temp[k])
                adj[temp[k]].add(temp[j])
            }
        }
    }
    repeat(n) {
        for (i in n downTo 1) {
            for (j in adj[i]) {
                if (truth.contains(j) || truth.contains(i)) {
                    truth.add(i)
                    truth.add(j)
                }
            }
        }
    }

    val visited = BooleanArray(n + 1) { false }
    fun dfs(n: Int) {
        visited[n] = true
        for (i in adj[n]) {
            if (!visited[i] && truth.contains(i)) {
                truth.add(i)
                dfs(i)
            }
        }
    }

    var cnt = 0

    for (i in 0 until truth.size) {
        dfs(truth[i])
    }
    for (i in 0 until m) {
        for (j in 0 until party[i].size) {
            if (truth.contains(party[i][j])) {
                cnt++
                break
            }
        }
    }
    print(m - cnt)
}
