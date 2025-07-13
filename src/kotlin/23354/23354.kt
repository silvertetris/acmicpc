import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dx = intArrayOf(0, 1, 0, -1)//상 하 좌우
    val dy = intArrayOf(1, 0, -1, 0)
    val arr = Array(n) {IntArray(n)}
    //note: X가 Y 고 Y가 X임 잘못적음 헷갈리면 안됨
    var startX = 0
    var startY = 0
    val flee = mutableListOf<Pair<Int, Int>> ()
    for(i in 0 until n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        for(j in 0 until n) {
            if(temp[j] == -1) {
                startX = i
                startY = j
                arr[i][j] = 0
                continue
            }
            else if(temp[j] == 0) {
                flee.add(i to j)
            }
            arr[i][j] = temp[j]
        }
    }
    var initX = startX
    var initY = startY
    //dijkstra를 처음에 부대로부터 가장 거리가 짧은 탈영병 잡고, 또 그거 기준으로 또 잡고 잡고 잡고 다 잡으면 그게 마지막으로 부대까지 복귀한는 수순
    fun dijkstra(startX:Int, startY:Int): Array<IntArray> {
        val dist = Array(n) {IntArray(n) {Int.MAX_VALUE-1000} }
        val pq = PriorityQueue<Pair<Pair<Int, Int>, Int>>(compareBy { it.second })
        dist[startX][startY] = 0
        pq.add(Pair(startX to startY, 0))
        while(pq.isNotEmpty()) {
            val(cur, curDist) = pq.poll()
            val(curX, curY) = cur
            for(i in 0 until 4) {
                val nx = curX + dx[i]
                val ny = curY + dy[i]
                if(nx in 0 until n && ny in 0 until n && dist[nx][ny] > dist[curX][curY] + arr[nx][ny]) {
                    dist[nx][ny] = dist[curX][curY] + arr[nx][ny]
                    pq.add(Pair(nx to ny, dist[nx][ny]))
                }
            }
        }
        return dist
    }
    var answer = 0
    //1. 모든 flee 위치로부터의 최소 거리
    while(flee.isNotEmpty()) {
        var minIdx =0 to 0
        var minDist = Int.MAX_VALUE
        val dist :Array<IntArray> = dijkstra(startX, startY)
        for(i in 0 until flee.size){
            val(x, y) = flee[i]
            if(minDist>dist[x][y]) {
                minDist = dist[x][y]
                minIdx = x to y
            }
        }
        answer+=minDist
        startX = minIdx.first
        startY = minIdx.second
        flee.remove(minIdx)
    }
    val finalDist = dijkstra(initX, initY)
    answer+=finalDist[startX][startY]
    print(answer)
}