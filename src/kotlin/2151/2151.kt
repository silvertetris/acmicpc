import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) { CharArray(n) }
    for (i in 0 until n) {
        arr[i] = br.readLine().toCharArray()
    }

    var (initA, initB) = 0 to 0
    var flag = false
    var (destA, destB) = 0 to 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!flag) {
                if (arr[i][j] == '#') {
                    initA = i
                    initB = j
                    flag = true
                    continue
                }
            } else {
                if (arr[i][j] == '#') {
                    destA = i
                    destB = j
                    break
                }
            }
        }
    }
    data class Node(val cost: Int, val x: Int, val y: Int, val dir: Int)
    br.close()

    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    val dist = Array(4) { Array(n) { IntArray(n) { Int.MAX_VALUE - 1_000 } } }
    val pq = PriorityQueue<Node>(compareBy { it.cost })

    for (d in 0 until 4) {
        dist[d][initA][initB] = 0
        pq.add(Node(0, initA, initB, d))
    }

    while (pq.isNotEmpty()) {
        val (cost, x, y, dir) = pq.poll()
        if (cost != dist[dir][x][y]) continue
        if (x == destA && y == destB) { //목적지
            print(cost)
            return
        }

        val nx = x + dx[dir]
        val ny = y + dy[dir]
        if (nx in 0 until n && ny in 0 until n) {
            if (arr[nx][ny] == '*') continue
            else {
                if (dist[dir][nx][ny] > cost) {
                    dist[dir][nx][ny] = cost
                    pq.add(Node(cost, nx, ny, dir))
                }
                if (arr[nx][ny] == '!') {
                    val left = (dir + 3) % 4
                    val right = (dir + 1) % 4
                    if (dist[left][nx][ny] > cost + 1) {
                        dist[left][nx][ny] = cost + 1
                        pq.add(Node(cost + 1, nx, ny, left))
                    }
                    if (dist[right][nx][ny] > cost + 1) {
                        dist[right][nx][ny] = cost + 1
                        pq.add(Node(cost + 1, nx, ny, right))
                    }
                }
            }
        }

    }
}