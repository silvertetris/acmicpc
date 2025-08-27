fun main() {
    val br = System.`in`.bufferedReader()
    val(n, s) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var cnt =0
    fun dfs(idx:Int, sum:Int) {
        if(idx == n) {
            if(sum ==s) cnt++
            return
        }
        dfs(idx+1, sum+arr[idx])
        dfs(idx+1, sum)
    }

    dfs(0, 0)
    if(s==0) cnt-- //default == 0 (sum)
    print(cnt)
}