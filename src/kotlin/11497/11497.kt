fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val l = br.readLine().split(" ").map{it.toInt()}.toIntArray()
        l.sort()
        var answer = 0
        for(i in 0 until n-2) {
            val diff= l[i+2] - l [i]
            if(diff>answer) {
                answer = diff
            }
        }
        bw.write("${answer}\n")
    }
    bw.flush()
}