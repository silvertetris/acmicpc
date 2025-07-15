fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val INF = Int.MAX_VALUE - 1_0000
    val dist = Array(n + 1) { IntArray(n + 1) { INF } }
    val arr = Array(n + 1) { IntArray(n + 1) { 0 } }

    for (i in 0..n) {
        dist[i][i] = 0
    }
    repeat(m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        dist[temp[0]][temp[1]] = temp[2]
        dist[temp[1]][temp[0]] = temp[2]
        arr[temp[0]][temp[1]] = temp[1]
        arr[temp[1]][temp[0]] = temp[0]
    }
    for (k in 1..n) {
        for (i in 1..n) {
            if (dist[k][i] == INF) continue
            for (j in 1..n) {
                if (dist[k][j] == INF) continue
                val newDist = dist[i][k] + dist[k][j]
                if (newDist < dist[i][j]) { //i에서 j 로 가능 길목에 k 가 껴버림
                    dist[i][j] = newDist
                    arr[i][j] =
                        arr[i][k] //그러면 i에서 j 가는 길목에 이미 최초였던 i 에서 k 가는 첫 타자를 넣음 -> k로 하면 그 k 도 어디서부터 왔는지 모르기 때문에 틀림
                }
            }
        }
    }
    for (i in 1..n) {
        for (j in 1..n) {
            if (i == j) {
                bw.write("- ")
            } else
                bw.write("${arr[i][j]} ")
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}