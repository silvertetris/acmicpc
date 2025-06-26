fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = Array(n) {IntArray(n) }
    for(i in 0 until n) {
        arr[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val q = br.readLine().toInt()
    
}