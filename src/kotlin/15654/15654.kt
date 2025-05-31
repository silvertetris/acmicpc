

fun main() {
    val(n, m) = readln().split(" ").map { it.toInt() } // 총길이 = n, 부분길이 = m
    val a = readln().split(" ").map { it.toInt() }.sorted()
    val bw = System.out.bufferedWriter()
    val mark = BooleanArray(n) {false}
    val result = mutableListOf<Int>()
    fun subsets(depth: Int) {
        if(depth == m) {
            bw.write("${result.joinToString(" ")}\n")
            return
        }
        for(j in 0 until n) {
            if(!mark[j]) {
                mark[j] = true
                result.add(a[j])

                subsets(depth+1)

                result.removeLast()
                mark[j]= false

            }
        }
    }
    subsets(0)
    bw.flush()
}