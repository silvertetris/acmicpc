fun main() {
    val bw = System.out.bufferedWriter()
    val n = readln().toInt()
    /*
    1..n -> n^2 쌍 선택
    3
    1 1
    1 2
    1 3
    2 1
    2 2
    2 3
    3 1
    3 2
    3 3
    -> 하나씩 꼬리물고 물어서 -> n^2+1 수열이 나옴
    방문 확인?
     */
    val visited = Array(n+1) {BooleanArray(n+1) {false}}
    val res = IntArray(n*n+1) {1}
    fun dfs(depth:Int, x:Int) : Boolean{
        if(depth == n*n) {//끝에 다다름
            return true
        }
        for(i in 1..n) {
            if(!visited[x][i]) {
                visited[x][i] = true
                res[depth] = i

                if(dfs(depth+1, i)) { //끝에 다다름
                    return true
                }
                visited[x][i] = false
            }
        }
        return false
    }
    dfs(0, 1)
    bw.write("${n*n+1}\n")
    for(i in 0 until n*n+1) {
        bw.write("${res[i]} ")
    }
    bw.flush()
    bw.close()
}