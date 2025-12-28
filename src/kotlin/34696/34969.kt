fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val x = LongArray(m)
    val y = LongArray(m)
    for (i in 0 until m) {
        val(xi, yi) = br.readLine().split(" ").map { it.toLong() }
        x[i] = xi
        y[i] = yi
    }

    val s = br.readLine().trim().toInt() - 1

    val used = BooleanArray(m)
    val INF = Long.MAX_VALUE / 4
    val best = LongArray(m) { INF }

    fun dist2(i: Int, j: Int): Long {
        val dx = x[i] - x[j]
        val dy = y[i] - y[j]
        return dx * dx + dy * dy
    }

    used[s] = true
    best[s] = 0L

    for (i in 0 until m) if (!used[i]) best[i] = dist2(i, s) //첫 지점부터 모든 지점까지의 거리

    bw.write("${s+1}\n")

    for (p in 2..n) {
        // best 최대 자리 선택 (동점이면 번호 작은 것: 앞에서부터 스캔 + '>'만 사용)
        var pick = -1
        var mx = -1L
        for (i in 0 until m) {
            if (used[i]) continue
            val v = best[i]
            if (v > mx) {
                mx = v //가장 큰 거리로 갱신
                pick = i//가장 큰 거리 인덱스
            }
        }

        used[pick] = true
        best[pick] = 0L
        bw.write("${pick+1}\n")
        // 새로 앉은 점 pick으로 best 갱신: best[i] = min(best[i], dist2(i, pick))
        for (i in 0 until m) {
            if (used[i]) continue
            val d = dist2(i, pick)//모든 지점과 방금 선택한 가장 먼거리에 있는 인덱스 사이의 거리
            if (d < best[i]) best[i] = d //본래 있던 지점 거리에서 자기쪽에 가까운 애들을 싹다 가까운거리로 바꿈 -> 예전 거리보다 방금 선택한것이 거리가 더 짧으면 갱신
            //결국 이러면 두 지점 사이값들은 정렬되고 지점 밖에 있는 값들은 냅둬짐 -> 반복문 돌면서 가장 먼 거리에 있는걸 고르게 됨
        }
    }
    bw.flush()
}
