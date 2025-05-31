package kotlin

fun main() {
    val n = readln().toInt()
    var result = 0
    for(i in 1 until n) {
        result+=i
    }
    print(result)
}