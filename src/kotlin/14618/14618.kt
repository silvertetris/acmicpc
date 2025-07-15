import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() } //전체 집, 간선 수
    val j = br.readLine().toInt()// 잼서집 정점
    val k = br.readLine().toInt()// 씹순이 수 -> 2*k 전체
    val a = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val b = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val road = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        road[temp[0]].add(temp[1] to temp[2])
        road[temp[1]].add(temp[0] to temp[2])
    }
    val INF = Int.MAX_VALUE-100
    val apq = PriorityQueue<Pair<Int, Int>> (compareBy { it.second })
    val bpq = PriorityQueue<Pair<Int, Int>> (compareBy { it.second })

    val distA = IntArray(n+1) {INF}
    val distB = IntArray(n+1) {INF}
    for(i in 0 until k) {
        distA[a[i]] = 0
        distB[b[i]] = 0
        apq.add(a[i] to 0)
        bpq.add(b[i] to 0)
    }

    var resA = 0
    var resB = 0
    while(apq.isNotEmpty()) {
        val (cur, curDist) = apq.poll()
        if(curDist > distA[cur]) continue
        for((next, cost) in road[cur]) {
            if(distA[next] > curDist + cost) {
                distA[next] = curDist + cost
                apq.add(next to distA[next])
            }
        }
    }
    while(bpq.isNotEmpty()) {
        val (cur, curDist) = bpq.poll()
        if(curDist > distB[cur]) continue
        for((next, cost) in road[cur]) {
            if(distB[next] > curDist + cost) {
                distB[next] = curDist + cost
                bpq.add(next to distB[next])
            }
        }
    }
    resA = distA[j]
    resB = distB[j]

    if(resA ==INF && resB ==INF) print(-1)
    else {
        if(resA>resB) {
            println('B')
            print(resB)
        } else {
            println("A")
            print(resA)
        }
    }
}