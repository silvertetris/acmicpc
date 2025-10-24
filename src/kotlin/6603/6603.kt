fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    while (true) {
        val line = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        if (line[0] == 0) {
            return
        }
        //k, line[1]..line[k]
        /*
        그냥 주어진 집합에서 6개 선택하는 백트래킹?
         */
        val result = mutableListOf<Int>()
        val marked = BooleanArray(line[0]+1) { false }
        fun dfs(depth: Int, idx: Int) {
            if (depth == 6) {
                bw.write("${result.joinToString(" ")}\n")
                return
            }
            for (i in 1..line[0]) {
                if (!marked[i] && i >= idx) {
                    marked[i] = true
                    result.add(line[i])
                    dfs(depth + 1, i)
                    result.removeLast()
                    marked[i] = false
                }
            }
        }
        dfs(0, 1)
        bw.write("\n")
        bw.flush()
    }
}