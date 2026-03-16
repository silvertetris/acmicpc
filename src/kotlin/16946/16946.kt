fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val wall = Array(n) { BooleanArray(m) }

    for (i in 0 until n) {
        val line = br.readLine()
        for (j in 0 until m) {
            if (line[j] == '1') {
                wall[i][j] = true
            }
        }
    }
    /*
    ideal: 0들을 그룹화
    1 기준으로 4방향 1칸만 뻗어서 그룹화된 0 갯수 더함
     */
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    val sep = Array(n) {IntArray(m) {0} }
    val cnt = Array(500_000) {0}
    val visited = Array(n) { BooleanArray(m) }
    fun dfs(x: Int, y: Int, p:Int): Int {
        var total = 0
        visited[x][y] = true
        sep[x][y] = p

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 until n && ny in 0 until m && !visited[nx][ny] && !wall[nx][ny]) {
                total += dfs(nx, ny, p) + 1
            }
        }
        return total
    }

    var temp = 1
    for(i in 0 until n) {
        for(j in 0 until m) {
            if(!visited[i][j] && !wall[i][j]) {
                cnt[temp] = dfs(i, j, temp)+1
                temp++
            }
        }
    }


    for(i in 0 until n) {
        for(j in 0 until m) {
            if (!wall[i][j]) {
                bw.write("0")
            } else {
                var res = 1
                val rep = mutableSetOf<Int>()
                for (p in 0 until 4) {
                    val nx = i + dx[p]
                    val ny = j + dy[p]
                    if (nx in 0 until n && ny in 0 until m && !wall[nx][ny]) {
                        rep.add(sep[nx][ny])
                    }
                }
                for(r in rep) {
                    res+=cnt[r]
                }
                bw.write("${res%10}")
            }
        }
        bw.write("\n")
    }
    bw.flush()
}