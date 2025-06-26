import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val (timeStr, dStr) = br.readLine().split(" ")
        val startH = timeStr.substring(0, 2).toInt()
        val startM = timeStr.substring(3, 5).toInt()
        val d = dStr.toInt()
        val startMin = startH * 60 + startM //통일


        val dp = IntArray(d + 1) { 0 }

        for (pos in d - 1 downTo 0) {
            val absMin = (startMin + pos) % (24 * 60)

            val nextPosGen = min(d, pos + 60)
            val costGen = 1000 + dp[nextPosGen]

            var costNight = Int.MAX_VALUE
            if (absMin >= 22 * 60 || absMin < 8 * 60) {
                val cover = if (absMin >= 22 * 60) {
                    (24 * 60 - absMin) + 8 * 60
                } else {
                    8 * 60 - absMin
                }
                val nextPosNight = min(d, pos + cover)
                costNight = 5000 + dp[nextPosNight]
            }

            dp[pos] = min(costGen, costNight)
        }
        bw.write("${dp[0]}\n")
    }
    bw.flush()
    bw.close()
}
