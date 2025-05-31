package kotlin.`1654`

fun main() {
    val br = System.`in`.bufferedReader()
    val (k, n) = br.readLine().split(" ").map { it.toInt() }
    val len = IntArray(k)

    for (i in 0 until k) {
        len[i] = br.readLine().toInt()
    }
    var l = 0L
    var r = Long.MAX_VALUE
    while (l <= r) {
        val mid = (l + r) / 2
        var count = 0.toBigInteger()
        for (i in 0 until k) {
            count += (len[i] / mid).toBigInteger()
        }
        if (count >= n.toBigInteger()) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    print(l - 1)
}