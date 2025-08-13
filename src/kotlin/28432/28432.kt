fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) { "" }
    var idx = -1
    var first: Char? = null
    var second: Char? = null

    for (i in 0 until n) {
        arr[i] = br.readLine()
        if (arr[i] == "?") {
            idx = i
            if (i > 0) first = arr[i - 1].last()
        } else {
            if (idx != -1 && i == idx + 1) {
                second = arr[i].first()
            }
        }
    }

    if (idx != -1 && idx + 1 < n && arr[idx + 1] != "?") {
        second = arr[idx + 1].first()
    }

    val m = br.readLine().toInt()
    val ans = Array(m) { "" }
    val used = arr.filter { it != "?" }.toSet()

    for (i in 0 until m) {
        ans[i] = br.readLine()
        val temp = ans[i]
        if (temp in used) continue
        if (first != null && temp.first() != first) continue
        if (second != null && temp.last() != second) continue
        println(temp)
        return
    }
}
