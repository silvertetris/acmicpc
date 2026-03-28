fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        bw.write("${br.readLine().toInt()-1}\n")
    }
    bw.flush()
}