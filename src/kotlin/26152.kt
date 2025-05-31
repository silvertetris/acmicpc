package kotlin

fun main() {
    val reader = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = reader.readLine().toInt()
    val top = reader.readLine().split(" ").map { it.toLong() }
    val size = reader.readLine().split(" ").map { it.toLong() }.toMutableList()

    for (i in 0 until n) {
        size[i] = top[i] - size[i]
        if(i>0) {
            size[i] = minOf(size[i], size[i - 1])
        }
    }

    val q = reader.readLine().toInt()
    val now = reader.readLine().split(" ").map { it.toLong() }.toMutableList()

    for(i in 0 until q) {
        var l = 0
        var r = n - 1
        var m: Int

        while (l <= r) {
            m = (l + r) / 2
            if (size[m] < now[i]) {
                r = m - 1
            } else {
                l = m + 1
            }
        }
        bw.write("$l\n")
    }
    bw.flush()
    bw.close()
}
