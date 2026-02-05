fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val col = Array(n) { 0 to 0 }
    for (i in 0 until n) {
        val (l, h) = br.readLine().split(" ").map { it.toInt() }
        col[i] = l to h
    }
    col.sortBy { it.first }
    if (n == 1) {
        print(col[0].second)
        return
    }
    var maxIdx = 0

    for (i in n - 1 downTo 0) {
        if (col[i].second > col[maxIdx].second) maxIdx = i
    }
    var ans = 0
    var curMax = col[0]
    for (i in 1..maxIdx) {
        val curHeight = col[i].second
        val curPos = col[i].first
        if (curHeight >= curMax.second) {
            ans += (curPos - curMax.first) * curMax.second
            curMax = col[i]
        }
    }
    ans += col[maxIdx].second
    curMax = col[n - 1]
    for (i in n - 2 downTo maxIdx) {
        val curHeight = col[i].second
        val curPos = col[i].first
        if (curHeight >= curMax.second) {
            ans += (curMax.first - curPos) * curMax.second
            curMax = col[i]
        }
    }
    print(ans)
}