

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var (n, p, e) = br.readLine().split(" ").map { it.toInt() }
    val arr:Array<Pair<Int, Int>> = Array(n) { Pair(0,0)}
    for(i in 0 until n) {
        val(x, y) = br.readLine().split(" ").map { it.toInt() }
        arr[i] = x to y
    }
    arr.sortByDescending { it.first }
    val answer = IntArray(n) {0}

    var cnt = 0
    for(i in 0 until n) {
        if(e< arr[i].first) {
            continue
        }

    }
}