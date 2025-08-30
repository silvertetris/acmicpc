import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val bw= System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val (n, m) = br.readLine().split(" ")
        var cnt = 0
        var tempOne = 0
        var tempTow = 0
        for(i in 0 until n.length) {
            if(n[i]=='1' && m[i]=='0') {
                tempOne++
            }
            else if(n[i] == '0' && m[i]=='1') {
                tempTow++
            }
        }
        var oneCnt = n.count { it == '1' }
        var twoCnt = m.count { it == '1' }
        cnt+= abs(oneCnt - twoCnt)
        cnt+= minOf(tempOne, tempTow)
        bw.write("$cnt\n")
    }
    bw.flush()
    bw.close()
}