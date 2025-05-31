

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var result = 0

    repeat(n) {
        val(a, b) = br.readLine().split(" ").map { it.toInt() }
        if(a>b) {
            result+=a-b
        }
    }
    print(result)
}