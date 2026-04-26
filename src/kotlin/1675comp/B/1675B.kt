import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()

        var maxA = 0L
        var maxB = 0L
        var maxC = 0L
        var possible = true

        for (i in 1..n) {
            val st = StringTokenizer(br.readLine())
            val a = st.nextToken().toLong()
            val b = st.nextToken().toLong()
            val c = st.nextToken().toLong()
            val p = st.nextToken().toLong()

            if (possible) {
                if (a > maxA) maxA = a
                if (b > maxB) maxB = b
                if (c > maxC) maxC = c
                if (maxA + maxB + maxC + i > p) {
                    possible = false
                }
            }
        }

        if (possible) {
            bw.write("YES\n")
        } else {
            bw.write("NO\n")
        }
    }
    bw.flush()
    bw.close()
}