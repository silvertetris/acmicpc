import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, q) = br.readLine().split(" ").map { it.toInt() }
    val str = StringTokenizer(br.readLine())
    val arr = LongArray(q) {0L}
    for(i in 0 until q) {
        arr[i] = str.nextToken().toLong()
    }

}