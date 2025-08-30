fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map{ it.toInt() }.toIntArray()
    val left = IntArray(n)
    left[0] = 1
    var best = 1
    for (i in 1 until n) {
        left[i] = if (a[i] == a[i - 1]) left[i - 1] + 1 else 1
        if (left[i] > best) best = left[i]
    }

    val right = IntArray(n)
    right[n - 1] = 1
    for (i in n - 2 downTo 0) {
        right[i] = if (a[i] == a[i + 1]) right[i + 1] + 1 else 1
    }

    var ans = best
    for (i in 0 until n - 1) {
        if (a[i] != a[i + 1]) {
            ans = maxOf(ans, left[i] + right[i + 1])
        }
    }

    print(ans)
}
