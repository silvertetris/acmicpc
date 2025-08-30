fun main() {
    val br = System.`in`.bufferedReader()
    val arr = Array(5) { CharArray(5) }
    for(i in 0 until 5) {
        arr[i] = br.readLine().split(" ").map{it.toInt().toChar()}.toCharArray()
    }
    val result = mutableSetOf<String>()
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    fun dfs(x:Int, y:Int, depth:Int, temp: StringBuilder) {
        if(depth==5) {
            result.add(temp.toString())
            return
        }
        for(i in 0 until 4) {
            val rx = x + dx[i]
            val ry = y + dy[i]
            if(rx in 0 until 5 && ry in 0 until 5) {
                temp.append(arr[rx][ry])
                dfs(rx, ry, depth+1, temp)
                temp.deleteCharAt(temp.lastIndex)
            }
        }
    }
    for(i in 0 until 5) {
        for(j in 0 until 5) {
            val sb = StringBuilder()
            sb.append(arr[i][j])//초기 위치
            dfs(i, j, 0, sb)
        }
    }
    print(result.size)
}