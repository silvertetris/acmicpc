fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    /*
    새롭게 정의해야함 dx dy 헷갈렸음
     */
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(-1, 0, 1, 0)
    repeat(t) {
        val (r, c) = br.readLine().split(" ").map{it.toInt()}
        val poly = Array(r) {br.readLine().toCharArray()}
        val descr = Array(r) {br.readLine().split(" ").filter{it.isNotEmpty()}.map{it.toInt()}}
        val idxList = mutableListOf<MutableList<Int>>()
        val idx = mutableListOf<Int>()
        val visited = Array(r) {BooleanArray(c) {false}}
        fun dfs(x:Int, y:Int) {
            visited[x][y] = true
            idx.add(poly[x][y]-'0')
            val checkNum = Integer.toBinaryString(descr[x][y])
            for(i in checkNum.lastIndex downTo 0) {
                if(checkNum[i]!='1') continue
                val temp = checkNum.length-i-1
                val nx = x+dx[3-temp]
                val ny = y+dy[3-temp]
                if(nx in 0 until r && ny in 0 until c && !visited[nx][ny]) {
                    dfs(nx, ny)
                }
            }
        }
        //dfs
        for(i in 0 until r) {
            for(j in 0 until c) {
                if(!visited[i][j]) {
                    dfs(i, j)
                    idxList.add(idx.toMutableList())
                    idx.clear()
                }
            }
        }
        for(i in idxList.indices) {
            idxList[i].sort()
            for(j in 0 until idxList[i].size) {
                if(j+1 != idxList[i][j]) {
                    bw.write("invalid\n")
                    return@repeat
                }
            }
        }
        for(i in 0 until r) {
            for(j in 0 until c) {
                val num = poly[i][j]-'0'//거점
                //4방향으로 뻗기, i, j 에서 덧셈 뺄셈 -> 4가지 경우의 수
                for(k in 1 .. num) {
                    val up = i+k
                    val down = i-k
                    val left = j-k
                    val right = j+k
                    if(up in 0 until r && poly[up][j] == poly[i][j]) {
                        bw.write("invalid\n")
                        return@repeat
                    }
                    if(down in 0 until r && poly[down][j] == poly[i][j]) {
                        bw.write("invalid\n")
                        return@repeat
                    }
                    if(left in 0 until c && poly[i][left] == poly[i][j]) {
                        bw.write("invalid\n")
                        return@repeat
                    }
                    if(right in 0 until c && poly[i][right] == poly[i][j]) {
                        bw.write("invalid\n")
                        return@repeat
                    }
                }
            }
        }
        bw.write("valid\n")
    }
    bw.flush()
}