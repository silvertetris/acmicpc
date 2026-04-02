import java.util.StringTokenizer

fun main() {
    val br =System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val a = IntArray(n/2)
    val b = IntArray(n/2)
    val strA = StringTokenizer(br.readLine())
    val strB= StringTokenizer(br.readLine())
    for(i in 0 until n/2) {
        a[i] = strA.nextToken().toInt()
    }
    for(i in 0 until n/2) {
        b[i] = strB.nextToken().toInt()
    }
    fun init(node:Int, l:Int, r:Int) {

    }
}