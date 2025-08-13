import kotlin.math.pow

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    bw.write("${2.0.pow(n).toInt() -1}\n")
    fun move(n:Int, a:Int, b:Int, c:Int) {
        if(n==1) {
            bw.write("$a $c\n")
        } else {
            move(n-1, a, c, b)
            bw.write("$a $c\n")
            move(n-1, b, a, c)
        }
    }
    move(n, 1,2,3)
    bw.flush()
    bw.close()
}