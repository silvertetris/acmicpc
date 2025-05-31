package kotlin

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.toMutableList()
    val b = readln().split(" ").map { it.toInt() }.toMutableList()
    a.sort()
    b.sortDescending()
    var result =0
    for( i in 0 until n) {
        result+= a[i]*b[i]
    }
    print(result)
}