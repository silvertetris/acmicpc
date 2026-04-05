import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val str = StringTokenizer(br.readLine())
    val n = str.nextToken().toInt()
    val m = str.nextToken().toInt()
    val seg = LongArray(4*n+1) {0L}
    fun update(node:Int, l:Int, r:Int, idx:Int, cost:Int) {
        if(idx !in l..r) {
            return
        }else if (l==r) {
            seg[node] = cost.toLong()
        }
        else {
            val mid = (l+r) /2
            update(2*node, l, mid, idx, cost)
            update(2*node+1, mid+1, r, idx, cost)
            seg[node] = seg[2*node] + seg[2*node+1]
        }
    }
    fun sum (node:Int, start:Int, end:Int, l:Int, r:Int) :Long {
        if(start>r || end<l) {
            return 0L
        } else if(start>=l && end<=r) {
            return seg[node]
        } else {
            val mid = (start+end)/2
            return sum(2*node, start, mid, l, r) + sum(2*node+1, mid+1, end, l, r)
        }
    }
    for(i in 0 until m) {
        val str2 = StringTokenizer(br.readLine())
        val case = str2.nextToken().toInt()
        val first = str2.nextToken().toInt()
        val second = str2.nextToken().toInt()
        if(case==0) {
            bw.write("${sum(1, 0, n-1, minOf(first, second)-1, maxOf(first, second)-1)}\n")
        }
        else {
            update(1, 0, n-1, first-1, second)
        }
    }
    bw.flush()
}