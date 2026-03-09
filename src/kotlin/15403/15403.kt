fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val cnt = IntArray(100_001) { 0 }
    for(i in 0 until n) {
        cnt[a[i]]++
    }
    val tempArr = a.toMutableSet().sortedDescending()
    var idx = 0
    for(i in tempArr) {
        idx+=cnt[i]
        cnt[i] = idx
    }
    for(i in 0 until n) {
        bw.write("${cnt[a[i]]--} ")
    }
    bw.flush()
    bw.close()
}