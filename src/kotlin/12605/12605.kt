

fun main() {
    val t = readln().toInt()
    val result = StringBuilder()
    for(i in 0 until t) {
        val arr = readln().split(" ").toTypedArray()
        result.append("Case #${i+1}: ")
        for(j in arr.size-1 downTo 1) {
            result.append("${arr[j]} ")
        }
        result.append("${arr[0]}\n")
    }
    print(result)
}