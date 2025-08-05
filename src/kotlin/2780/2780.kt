fun main() {
    val br = System.`in`.bufferedReader()
    val bw= System.out.bufferedWriter()
    val t = br.readLine().toInt()
    val adj = Array(10) {mutableListOf<Int>() }
    adj[0].add(7)
    adj[1].addAll(listOf(2, 4))
    adj[2].addAll(listOf(1, 3, 5))
    adj[3].addAll(listOf(2, 6))
    adj[4].addAll(listOf(1, 5, 7))
    adj[5].addAll(listOf(2, 4, 6, 8))
    adj[6].addAll(listOf(3, 5, 9))
    adj[7].addAll(listOf(0, 4, 8))
    adj[8].addAll(listOf(5, 7, 9))
    adj[9].addAll(listOf(6, 8))
    repeat(t) {
        val n = br.readLine().toInt()

    }
}