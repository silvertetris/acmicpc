

fun main() {
    val t = readln().toInt()
    val result = StringBuilder()
    repeat(t) {
        val(n, m) = readln().split(" ").map { it.toInt() }
        repeat(m) {
            readln()
        }
        result.append("${n-1}\n")
    }
    print(result)
}