import kotlin.math.pow

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        if(n%3!=0) {
            bw.write("0\n")
            return@repeat
        }
        else {
            val temp = n/3
            bw.write("${2.0.pow(temp.toDouble()).toLong()}\n")
        }
    }
    bw.flush()
}