import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n =br.readLine().toInt()
    val dangerX1 = IntArray(n)
    val dangerY1 = IntArray(n)
    val dangerX2 = IntArray(n)
    val dangerY2 = IntArray(n)
    for(i in 0 until n) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
        dangerX1[i] = x1
        dangerY1[i] = y1
        dangerX2[i] = x2
        dangerY2[i] = y2
    }
    val m = br.readLine().toInt()
    val deathX1 = IntArray(m)
    val deathY1 = IntArray(m)
    val deathX2 = IntArray(m)
    val deathY2 = IntArray(m)
    for(i in 0 until m) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
        deathX1[i] = x1
        deathY1[i] = y1
        deathX2[i] = x2
        deathY2[i] = y2
    }

    val dx = intArrayOf(0, -1, 0, 1)
    val dy = intArrayOf(1, 0, -1, 0)
    val queue = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third })
    val dist = Array(501) {IntArray(501) {Int.MAX_VALUE-1_000}}
    queue.add(Triple(0,0,0))
    while(queue.isNotEmpty()) {
        val (curX, curY, curD) = queue.poll()
        for(i in 0 until 4) {
            val nx = curX + dx[i]
            val ny = curY + dy[i]
            if(nx !in 0 until 501 || ny !in 0 until 501) continue
            var nd = curD
            var deathFlag = false
            for(i in 0 until m) {
                if((nx in deathX1[i]..deathX2[i] || nx in deathX2[i] .. deathX1[i]) && (ny in deathY1[i]..deathY2[i] || ny in deathY2[i] .. deathY1[i])) {
                    deathFlag = true
                }
            }
            if(deathFlag) continue
            for(i in 0 until n) {
                if((nx in dangerX1[i]..dangerX2[i] || nx in dangerX2[i] .. dangerX1[i]) && (ny in dangerY1[i]..dangerY2[i] || ny in dangerY2[i] .. dangerY1[i])) {
                    nd+=1
                    break
                }
            }
            if(dist[nx][ny] >nd) {
                dist[nx][ny] = nd
                queue.add(Triple(nx, ny, nd))
            }
        }
    }
    if(dist[500][500] > Int.MAX_VALUE-1_000_000) {
        print(-1)
    } else print(dist[500][500])
}