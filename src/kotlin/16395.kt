

fun dp(n: Int, k: Int): Int {
    if (k == 0 || k == n) return 1
    var result = 1
    for (i in 0 until k) {
        result = result * (n - i) / (i + 1)
    }
    return result
}

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    print(dp(n - 1, k - 1))
}