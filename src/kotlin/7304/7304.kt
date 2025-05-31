

fun main() {
    val t = readln().toInt()
    val result = StringBuilder()
    repeat(t) {
        readln()
        val n = readln().split(' ').map { it.toInt() }.sortedDescending()
        var temp = 0

        for(i in n.indices) {
                temp = maxOf(n[i]*(i+1), temp)
        }
        result.append("$temp\n")
    }
    print(result)
}