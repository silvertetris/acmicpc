import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) {CharArray(n)}
    for(i in 0 until n) {
        arr[i] = br.readLine().toCharArray()
    }
    var (initA, initB) = 0 to 0
    for(i in 0 until n) {
        val temp = arr[i].indexOf('#')
        if(!temp.equals(-1)) {
            initA = i
            initB = temp
            break
        }
    }
    br.close()
    //먼저 여기서 #의 위치 특정 후 초기 방향 잡기

    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, -1, 0, 1)
    if(initA == 0) {
        initA = 1
    } else if(initB == 0) {
        initA = 0
    } else if(initA == n-1) {
        initA = 3
    } else {
        initA = 2
    }

    fun dijkstra(starty:Int, startx:Int) {
        var initDir = initA
        val dist = Array(n) {IntArray(n) {Int.MAX_VALUE-100_000} }
        val queue = PriorityQueue<Pair<Int, Pair<Int, Int>>> (compareBy {it.first}) //curDist, i, j

        queue.add(Pair(0, starty to startx)) //초기 방향 추가
        while(queue.isNotEmpty()) {
            val(curDist, curIdx) = queue.poll() //이후 방향 추가 (5) 면 for문 돌리기
            val(curRow, curCol) = curIdx
            if(curDist > dist[curRow][curCol]) continue
            if(initA!=5) {
                val nRow = curRow + dy[initDir]
                val nCol = curCol + dx[initDir]
                if(nRow in 0 until n && nCol in 0 until n) {
                    if(arr[nRow][nCol] == '.') {
                        dist[nRow][nCol] = minOf(curDist, dist[nRow][nCol])
                        queue.add(Pair(curDist, nRow to nCol))
                    }
                }
            }
            if(initA == 5) {
                for(i in 0 until 4) {
                    val nRow = curRow + dy[i]
                    val nCol = curCol + dx[i]
                    if(nRow in 0 until n && nCol in 0 until n) {
                    }
                }
            }
        }
    }
    /*
    문이 2개
한쪽 문에서 다른 쪽의 문을 보고 싶게 거울 설치
집 정보 주어지고, 거울 설치 최소 개수
45도 기울어진 대각선 방향
모든 거울은 양면 거울
정해야하는것
1. 항상 #을 기준으로 방향을 한가지고 정의됨
2. 그 방향에서 !를 만났을때, 그냥 . 일때를 정해야함
3. !를 만났을 때, 해당 양옆 방향으로 뻗게 됨
어떻게 보면 그냥 통과도 가능함
결국에 방향을 꺾는 경우는 !가 있을 경우고
나머지는 해당 방향에 대해 계속 가야함

     */
}