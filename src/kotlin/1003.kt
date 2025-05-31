
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    val zero = Array(41) { 0 }
    val one = Array(41) { 0 }
    zero[0] = 1
    zero[1] = 0
    one[0] = 0
    one[1] = 1
    for(i in 2..40) {
        zero[i] = zero[i - 1] + zero[i - 2]
        one[i] = one[i - 1] + one[i - 2]
    }
    repeat(t) {
        val n = br.readLine().toInt()
        bw.write("${zero[n]} ${one[n]}\n")
    }
    bw.flush()
    bw.close()
}