fun main() {
    val br= System.`in`.bufferedReader()
    val(n, m) = br.readLine().split(" ").map { it.toInt() }
    val parent = IntArray(n+1) {it}
    val indegree = IntArray(n+1) {0}
    fun find(i:Int) :Int {
        if(parent[i] !=i) {
            parent[i] = find(parent[i])
        }
        return parent[i]
    }
    fun union(a:Int, b:Int) {
        val leftParent = find(a)
        val rightParent = find(b)
        if(leftParent == rightParent) return
        if(indegree[leftParent] < indegree[rightParent])  {
            parent[leftParent] = rightParent
        } else if(indegree[leftParent] > indegree[rightParent]) {
            parent[rightParent] = leftParent
        } else {
            parent[rightParent] = leftParent
            indegree[leftParent]++
        }

    }
    repeat(m) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        union(u, v)
    }
    val code = br.readLine().split(" ").map{ it.toInt() }.toIntArray()
    var cnt = 0;
    for(i in 0 until n-1) {
        if(find(code[i]) != find(code[i+1])) {
            cnt++
        }
    }
    print(cnt)
}