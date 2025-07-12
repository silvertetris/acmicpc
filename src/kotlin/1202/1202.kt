fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val jewels = Array(n) {0 to 0}
    for(i in 0 until n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        jewels[i] = temp[0] to temp[1]
    }
    val c = IntArray(k)
    for(i in 0 until k) {
        c[i] = br.readLine().toInt()
    }
    c.sort()
    jewels.sortBy { it.first }

}