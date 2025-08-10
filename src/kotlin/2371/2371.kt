fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) {mutableListOf<Int>()}
    var maxLen = 0
    for(i in 0 until n) {
        arr[i] = br.readLine().split(" ").map { it.toInt() }.toMutableList()
        maxLen = maxOf(maxLen, arr[i].size)
    }
    var cnt = 0
    for(i in 0 until maxLen) {
        for(j in 0 until n) {
            if(i> arr[j].lastIndex) break
            else {

            }
        }
    }
}