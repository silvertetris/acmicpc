package kotlin.`2805`

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toLong() }.toTypedArray()
    var l = 0
    var r = Int.MAX_VALUE
    while (l <= r) {
        val mid = (l + r) / 2
        var len = 0L //얘는 합이기 때문에 Long으로 두어야함
        for (i in arr.indices) {
            if (arr[i] > mid) {
                len += arr[i] - mid
            }
        }
        if (len >= m) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    bw.write("${l - 1}")
    bw.flush()
    bw.close()
}