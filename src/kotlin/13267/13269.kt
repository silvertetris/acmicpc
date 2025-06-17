fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val(n, m) = br.readLine().split(" ").map{ it.toInt() }
    val top = Array(n) {br.readLine().split(" ").map{ it.toInt() }}
    val forward = br.readLine().split(" ").map{ it.toInt() }
    val right = br.readLine().split(" ").map{ it.toInt() }

    for (j in 0 until m) {
        if (forward[j] == 0) continue  // 높이 0은 항상 가능
        var ok = false
        for (i in 0 until n) {
            if (top[i][j] == 1 && right[i] >= forward[j]) {
                ok = true; break
            }
        }
        if (!ok) {
            bw.write("-1\n"); bw.flush(); return
        }
    }
}