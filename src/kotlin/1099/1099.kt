fun main() {
    val br = System.`in`.bufferedReader()
    val s = br.readLine()
    val n = br.readLine().toInt()
    val word = Array(n) { br.readLine()}
    val dp = IntArray(s.length) {0}
    for(i in s.indices) {
        for(j in 0 until n) {
            var flag = false
            for(k in word[j].indices) {

            }
        }
    }
}