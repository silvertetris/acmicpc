fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val r = k % 6
    val ans = if (n % 2 == 0) {
        r != 1
    } else {
        r != 0 && r != 5
    }
    print(if (ans) "YG" else "HS")
}
