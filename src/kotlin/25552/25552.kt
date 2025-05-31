

import java.util.*
import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val initialGrass = Array(n) { CharArray(m) }
    val futureGrass = Array(n) { CharArray(m) }
    val visited = Array(n) { BooleanArray(m) }
    val q: Queue<Pair<Int, Int>> = LinkedList()

    for (i in 0 until n) {
        val temp = br.readLine()
        for (j in 0 until m) {
            initialGrass[i][j] = temp[j]
            if (initialGrass[i][j] == 'O') {
                visited[i][j] = true
                q.add(Pair(i, j))
            }
        }
    }

    val d = br.readLine().toInt()
    for (i in 0 until n) {
        val temp = br.readLine()
        for (j in 0 until m) {
            futureGrass[i][j] = temp[j]
        }
    }

    //bfs
    while (q.isNotEmpty()) {
        val (x, y) = q.poll()
        for (i in (x - d)..(x + d)) {//좌표 거리 (맨해튼 거리 제한)
            for (j in (y - d)..(y + d)) {
                if (i in 0 until n && j in 0 until m &&
                    abs(x - i) + abs(y - j) <= d &&
                    futureGrass[i][j] == 'O' && !visited[i][j]
                ) {
                    visited[i][j] = true //가능한 초기 미래 좌표
                    q.add(Pair(i, j))//이 초기 미래 좌표를 가지고 계속 퍼뜨림 (bfs)
                }
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            //1. 처음 잔디부터 시작된 bfs의 visited가 future에 도달할 수 없을 때
            //2. 그냥 애초에 불가능한 경우 (O가 X가 될 순 없으니)
            if ((futureGrass[i][j] == 'O' && !visited[i][j]) ||
                (futureGrass[i][j] == 'X' && initialGrass[i][j] == 'O')
            ) {
                print("NO")
                return
            }
        }
    }
    print("YES")
}