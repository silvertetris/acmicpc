import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = ArrayList<Pair<Long, Long>> (n)
    for(i in 0 until n) {
        val (a, b) = br.readLine().split(" ").map { it.toLong() }
        arr.add(Pair(a, b))
    }
    arr.sortWith(compareBy<Pair<Long, Long>> {it.first}.thenBy{it.second})
    val q = PriorityQueue<Long>()
    for(i in arr.indices){
        q.add(arr[i].second)
        if(q.peek()<=arr[i].first) {
            q.poll()
        }
    }
    print(q.size)
}