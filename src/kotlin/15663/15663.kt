package kotlin.`15663`

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }.sorted()
    val bw = System.out.bufferedWriter()
    val check = BooleanArray(n) { false }
    val answer = mutableListOf<Int>()
    val sol:MutableSet<MutableList<Int>> = mutableSetOf()
    fun subsets(depth:Int) {
        if(depth==m) {
            sol.add(answer.toMutableList())
            return
        }
        for(i in 0 until n) {
            if(!check[i] && i<1) {
                check[i]=true
                answer.add(a[i])
                subsets(depth+1)
                answer.removeLast()
                check[i]=false
            }
            else if(!check[i] && a[i]>=a[i-1]) {
                check[i]=true
                answer.add(a[i])
                subsets(depth+1)
                answer.removeLast()
                check[i]=false
            }
        }
    }
    subsets(0)
    for(i in 0 until sol.size) {
        bw.write("${sol.elementAt(i).joinToString(" ")}\n")
    }
    bw.flush()
    bw.close()
}