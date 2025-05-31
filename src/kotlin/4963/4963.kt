package kotlin.`4963`

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    while(true) {
        val(w, h) = br.readLine().split(' ').map { it.toInt() }
        if(w==0 && h ==0) break
        val adj = Array(51) {ArrayList<Int>()}

    }
    bw.flush()
    bw.close()
}