

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val bw = System.out.bufferedWriter()
    val mark = BooleanArray(n+1)
    val result = mutableListOf<Int>()

    fun dfs(depth:Int, idx:Int) {
        if(depth == m) {
            bw.write("${result.joinToString(" ")}\n")
            return
        }

        for(i in 1..n) {
            if(!mark[i] && i>idx) {
                mark[i] = true
                result.add(i)
                dfs(depth+1, i)
                result.removeAt(result.lastIndex)
                mark[i] = false
            }
        }
    }
    dfs(0, 0)
    bw.flush()
}