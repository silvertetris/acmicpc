

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val hate = Array(n + 1) { mutableSetOf<Int>() }
    for (i in 1..n) {
        var temp = br.readLine().trim().split(" ").map { it.toInt() }.toList()
        temp = temp.drop(1)
        //print(temp)
        for (j in 1..n) {
            if (temp.contains(j)) {
                hate[i].add(j)
                hate[j].add(i)
            }
        }
    }
    val team = IntArray(n + 1) { 0 } // not visited = 0 , blue team = 1, white team = 2
    val blue = mutableSetOf<Int>()
    val white = mutableSetOf<Int>()
    fun dfs(u: Int, t: Int) {
        team[u] = t
        for (v in hate[u]) {
            if (team[v] == 0) {
                dfs(v, 3 - t) //1 아니면 2만 나옴 => 내부 bool
            }
        }
    }

    for (i in 1..n) {
        if (team[i] == 0) dfs(i, 1) //not visited => 한번 더 dfs (여러개 cycle 나옴)
    }
    for (i in 1..n) {
        if (team[i] == 1) blue.add(i)
        else white.add(i)
    }

    println(blue.size)
    println(blue.joinToString(" "))
    println(white.size)
    println(white.joinToString(" "))
}