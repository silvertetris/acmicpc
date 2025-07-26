fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val cnt = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    br.close()
    val tall = mutableListOf<Int>()
    for(i in n-1 downTo 0) {
        tall .add(cnt[i], i)
    }
    for(i in 0 until n) {
        print("${tall[i]+1} ")
    }
}