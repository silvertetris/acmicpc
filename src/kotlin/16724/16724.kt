fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { CharArray(m) { ' ' } }
    for (i in n-1 downTo 0) {
        arr[i] = br.readLine().toCharArray()
    }
    val dy = intArrayOf(1, 0, -1, 0)
    val dx = intArrayOf(0, 1, 0, -1)
    //지도 탈출 방향은 안주어짐 -> 컨디션 체크 불필요
    //제일 많이 모이는 사이클->어떤 따로있는놈이 사이클에 수렴하면 하나로 통합 가능
    /*
    1. cycle 용 또 다른 배열 만든다?
     */
    val visited = Array(n) { BooleanArray(m) { false } }
    val cycle = Array(n) { BooleanArray(m) { false } }
    var cnt = 0
    fun dfs(y: Int, x: Int):Boolean {
        visited[y][x] = true
        var ny = 0
        var nx = 0
        when (arr[y][x]) {
            'U' -> {
                ny = y + dy[0]
                nx = x + dx[0]
            }

            'R' -> {
                ny = y + dy[1]
                nx = x + dx[1]
            }

            'D' -> {
                ny = y + dy[2]
                nx = x + dx[2]
            }

            'L' -> {
                ny = y + dy[3]
                nx = x + dx[3]
            }
        }
        if (!visited[ny][nx]) { //일단 한걸음 감 ->이미 사이클에 대해 현재 위치는 표시됨
            if(dfs(ny, nx)) {
                cycle[y][x] = true
                return true
            }
        }
        if(!cycle[ny][nx]) { //한 사이클 뒷가락 확인되면 추가
            cnt++
            cycle[ny][nx]= true
            cycle[y][x]= true
            return true
        }

        cycle[y][x] = true
        return false
    }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!visited[i][j]) {
                dfs(i, j)
            }
        }
    }
    print(cnt)
}