import java.util.StringTokenizer

fun main() {
    /*
    가중치 없는 그래프
    갈 수 있는 지에 대한 여부
    1. 이전 정보를 list에 담는다.
    가 의미가 없는게 어차피 0부터 n-1까지 탐색함
    -> 그러면 맨 처음것만 가져오면 됨
     */
    val br = System.`in`.bufferedReader()
    val bw= System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val arr = Array(n) {BooleanArray(n) {false} }
    for(i in 0 until n) {
        val str = StringTokenizer(br.readLine())
        for(j in 0 until n) {
            val temp = str.nextToken().toInt()
            if(temp==1) {
                arr[i][j] = true
            }
        }
    }
    val result = Array(n) {BooleanArray(n)}
    fun dfs(x:Int, prev:Int, visited:BooleanArray) {
        for(i in 0 until n) {
            if(arr[prev][i] && !visited[i]) {
                visited[i] = true
                result[prev][i] = true
                result[x][i] = true
                dfs(x, i, visited)
            }
        }
    }
    for(i in 0 until n) {
        val visited = BooleanArray(n) {false}
        dfs(i, i, visited)
    }
    for(i in 0 until n) {
        for(j in 0 until n) {
            if(result[i][j]) {
                bw.write("${1} ")
            } else {
                bw.write("${0} ")
            }
        }
        bw.write("\n")
    }
    bw.flush()
}