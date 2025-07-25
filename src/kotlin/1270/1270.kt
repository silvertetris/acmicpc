fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    repeat(n) {
        val parts = br.readLine().split(' ')
        val t = parts[0].toInt()
        val countMap = mutableMapOf<Long, Int>()

        for (i in 1..t) {
            val num = parts[i].toLong()
            countMap[num] = countMap.getOrDefault(num, 0) + 1
        }

        val leader = countMap.entries.find { it.value > t / 2 }?.key
        if (leader != null) {
            bw.write(leader.toString())
        } else {
            bw.write("SYJKGW")
        }
        bw.newLine()
    }

    bw.flush()
    bw.close()
}
