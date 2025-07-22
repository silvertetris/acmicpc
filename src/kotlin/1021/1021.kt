import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val pos = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val deq: Deque<Int> = LinkedList()
    for(i in 1.. n) {
        deq.add(i)
    }
    var result = 0
    for(i in 0 until m) {
        val cur = pos[i]
        val idx = deq.indexOf(cur)
        if(idx<= deq.size-idx) {
            for(j in 0 until idx) {
                val temp = deq.pollFirst()
                deq.add(temp)
                result++
            }
        } else {
            for(j in 0 until deq.size-idx) {
                val temp = deq.pollLast()
                deq.addFirst(temp)
                result++
            }
        }
        deq.pollFirst()
    }
    print(result)
}