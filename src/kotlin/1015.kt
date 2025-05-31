

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.toMutableList()
    var b = a.sorted().toMutableList()
    var result = Array<Int>(n){0}
    for(i in 0 until n) {
        for(j in 0 until n) {
            if(b[j]==a[i]) {
                result[i] = j
                b[j]=0
                break
            }
        }
    }
    print(result.joinToString(" "))
}