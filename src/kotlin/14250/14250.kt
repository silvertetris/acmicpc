fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val l = IntArray(m)
    val r = IntArray(m)
    for(i in 0 until m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        l[i] = temp[0]
        r[i] = temp[1]
    }
    br.close()
    val dp = Array(n) {IntArray(m) {0} }
    for(i in 0 until n) {
        for(j in 0 until m) {
            
        }
    }
}