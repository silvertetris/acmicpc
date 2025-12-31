fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m, q) = br.readLine().split(" ").map { it.toInt() }
    val a = Array(n) { IntArray(m) } //누적 합
    a[0] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    for (i in 1 until n) {
        a[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        for (j in 0 until m) {
            a[i][j] += a[i - 1][j]
        }
    }

    val dp = Array(n) { IntArray(m) { 0 } }
    /*
    dp[i-1][j-1]을 그냥 더하면 문제점
    -> 그 이전 것도 사실상 이미 row 에 대한 누적합임 -> 누적합 중복 그럼 일단 배열을 2개 쓰는게 맞음 (로직 분리를 위해)
     */
    dp[0] = a[0]
    for(i in 1 until n) {
        for(j in 0 until m) {
            if(j>=1) {
                dp[i][j] = dp[i-1][j-1] + a[i][j]
            }
            else {
                dp[i][j] = a[i][j]
            }
        }
    }
    /*
    bw.write("${a[0].toList()}\n")
+
    for (i in 1 until n) {
        val temp = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        a[i][0] = temp[0] + a[i - 1][0]
        for (j in 1 until m) {
            a[i][j] = temp[j] + a[i - 1][j - 1] + a[i - 1][j]
        }
        bw.write("${a[i].toList()}\n")
    }
    */
    for (i in 0 until q) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        bw.write("${dp[u-1][v-1]}\n")
    }
    bw.flush()
}