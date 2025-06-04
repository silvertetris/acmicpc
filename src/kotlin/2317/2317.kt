import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val lion = LongArray(k)
    val h = LongArray(n-k)
    for(i in 0 until n-k) {
        h[i] = br.readLine().toLong()
    }
    for(i in 0 until k) {
        lion[i] = br.readLine().toLong()
    }
    lion.sort()
    h.sortDescending()
    val lion2 = lion.copyOf()
    val h2 = h.copyOf()
    lion2.sortDescending()
    h2.sort()
    val one = lion + h
    val two = lion2 + h2
    var ans1 = 0L
    var ans2 = 0L

    for(i in 1 until n) {
        ans1 += abs(one[i] - one[i-1])
        ans2 += abs(two[i] - two[i-1])
    }

    print(minOf(ans1, ans2))
}