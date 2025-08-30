import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    val arr = Array(n) { CharArray(n) }
    for (i in 0 until n) {
        arr[i] = br.readLine().toCharArray()
    }
    //r, g match
    val rgVisited = Array(n) { BooleanArray(n) { false } }
    val visited = Array(n) {BooleanArray(n) { false } }
    fun bfs(x:Int, y:Int, flag:Boolean) {
        val q:Queue<Pair<Int, Int>> = LinkedList()
        val color = arr[x][y]
        if(flag) {
            q.add(x to y)
            while(q.isNotEmpty()) {
                val (curX, curY) = q.poll()
                for(i in 0 until 4) {
                    val nx = curX + dx[i]
                    val ny = curY+ dy[i]
                    if(nx in 0 until n && ny in 0 until n  && !rgVisited[nx][ny]) {
                        if((color == 'R' || color =='G') && (arr[nx][ny] =='R' || arr[nx][ny] == 'G')) {
                            rgVisited[nx][ny] = true
                            q.add(nx to ny)
                        }
                        else if(arr[nx][ny] == color) {
                            rgVisited[nx][ny] = true
                            q.add(nx to ny)
                        }
                    }
                }
            }

        } else {
            q.add(x to y)
            while(q.isNotEmpty()) {
                val (curX, curY) = q.poll()
                for(i in 0 until 4) {
                    val nx = curX + dx[i]
                    val ny = curY + dy[i]
                    if(nx in 0 until n && ny in 0 until n && arr[nx][ny] == color && !visited[nx][ny]) {
                        visited[nx][ny] = true
                        q.add(nx to ny)
                    }
                }
            }
        }
    }
    var rgb = 0
    var rg = 0
    for(i in 0 until n) {
        for(j in 0 until n) {
            if(!visited[i][j]) {
                bfs(i, j, false)
                rgb++
            }
            if(!rgVisited[i][j]) {
                bfs(i, j, true)
                rg++
            }
        }
    }
    print("$rgb $rg")
}