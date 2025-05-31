

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val a = Array(n) { Pair(0, 0) }
    for (i in 0 until n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        a[i] = Pair(temp[0], temp[1])
    }
    a.sortBy { it.first }
    var answer = 0
    var remain = -1

    for (i in 0 until n) {
        if(remain< a[i].first) {
            answer++
        }
        remain = a[i].first + a[i].second
    }
    print(answer)
}