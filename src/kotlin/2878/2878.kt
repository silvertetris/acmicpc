fun main() {
    val br = System.`in`.bufferedReader()
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val arr = LongArray(n)
    for (i in 0 until n) arr[i] = br.readLine().toLong()

    var sum = arr.sum()
    arr.sort()
    sum -= m

    var ans = 0L
    for (i in 0 until n) {
        val temp = minOf(arr[i], sum / (n - i))
        ans += temp * temp
        sum -= temp
    }
    print(ans)
}
