fun main() {
    val (a, b) =readln().split(" ").map { it.toBigInteger() }
    println(a/b)
    println(a%b)
}