import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val x = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val pq = PriorityQueue<Int>(compareByDescending { it })
    var sum = 0L
    var ans = 0
    for(i in x) {
        sum+=i
        pq.add(i)
        while(sum >=m) {
            val max = pq.poll()
            sum-= 2L * max
            ans++
        }
    }
    print(ans)
}