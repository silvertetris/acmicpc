fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val a = IntArray(n)
    val indices = IntArray(n)
    repeat(n) {
        val(u, v) = br.readLine().split(" ").map{it.toInt()}
        indices[it] = u
        a[u] = v
    }
    // min cartesian tree

}