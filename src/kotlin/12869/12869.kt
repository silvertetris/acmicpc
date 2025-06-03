fun main() {
    val br= System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val scv = br.readLine().split(" ").map{ it.toInt() }.toIntArray()
    val arr = IntArray(3) {0}
    for(i in 0 until scv.size) {
        arr[i] = scv[i]
    }
    val dp = Array(arr[0]) {Array(arr[1]) {IntArray(arr[2]) {0} } }


}