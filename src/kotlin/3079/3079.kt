

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val(n, m) = br.readLine().split(" ").map { it.toInt() } //심사대 수, 사람 수
    val t = IntArray(n)
    for(i in 0 until n) {
        t[i] = br.readLine().toInt()
    }
    
}