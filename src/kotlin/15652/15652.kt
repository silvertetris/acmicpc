

fun main() {
    val(n, m) = readln().split(" ").map { it.toInt() } // 총길이 = n, 부분길이 = m
    val bw = System.out.bufferedWriter()
    val mark = BooleanArray(n+1) {false}
    val result = mutableListOf<Int>()
    fun subsets(i:Int,depth: Int) {
        if(depth == m) {
            bw.write("${result.joinToString(" ")}\n")
            return
        }
        for(j in 1 .. n) {
            if(j>=i) {
                mark[j] = true
                result.add(j)

                subsets(j, depth+1)

                result.removeLast()
                mark[j]= false

            }
        }
    }
    subsets(0,0)
    bw.flush()
}