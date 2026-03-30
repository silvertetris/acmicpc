import java.util.StringTokenizer

fun main() {
    val br= System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val str = StringTokenizer(br.readLine())
    val a = IntArray(n)
    for(i in 0 until n) {
        a[i] = str.nextToken().toInt()
    }
    val m = br.readLine().toInt()

    val seg = IntArray(4*n+1)
    fun init(node:Int, l:Int, r:Int) {
        if(l==r) {
            seg[node] = l
        } else {
            val mid = (l+r)/2
            init(2*node, l, mid)
            init(2*node+1, mid+1, r)
            if(a[seg[2*node]]<=a[seg[2*node+1]]) {
                seg[node] = seg[2*node]
            } else seg[node] = seg[2*node+1]
        }
    }
    fun init2(node:Int, l:Int, r:Int, idx:Int) {
        if(idx !in l .. r) return
        if(l == r) {
            seg[node] = l
        } else {
            val mid = (l+r)/2
            init2(2*node, l, mid, idx)
            init2(2*node+1, mid+1, r, idx)
            if(a[seg[2*node]]<=a[seg[2*node+1]]) {
                seg[node] = seg[2*node]
            } else seg[node] = seg[2*node+1]
        }

    }
    init(1, 0, n-1)

    repeat(m) {
        val line = br.readLine().split(" ").map{it.toInt()}
        if(line[0] ==1) {
            a[line[1]-1] = line[2]
            init2(1, 0, n-1, line[1]-1)
        } else {
            bw.write("${seg[1]+1}\n")
        }
    }
    bw.flush()
}