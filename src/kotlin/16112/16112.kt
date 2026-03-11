import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val a = LongArray(n) { 0 }
    val sc = StringTokenizer(br.readLine())
    for(i in 0 until n) {
        a[i] = sc.nextToken().toLong()
    }
    a.sort()
    var ans = 0L
    for (i in 0 until n) {
        ans += a[i] * minOf(k, i)
    }
    print(ans)
}