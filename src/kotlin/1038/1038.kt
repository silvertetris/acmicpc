fun main() {
    val n = readln().toInt()
    val mark = BooleanArray(10) {false}
    val result = mutableListOf<Int>()
    fun dfs(cnt:Int) { //증가하는 수 reversed() ??
        if(cnt == n) {
            print(result.reversed().joinToString(" "))
            return
        }
        for(i in 0 .. 9) {
            if(!mark[i]) {
                mark[i] = true
                result.add(i)
                dfs(cnt+1)
                result.removeLast()
                mark[i] = false
            }
        }
    }
    dfs(0)
}