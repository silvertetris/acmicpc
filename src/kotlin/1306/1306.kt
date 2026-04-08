import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val str = StringTokenizer(br.readLine())
    val n = str.nextToken().toInt()
    val m = str.nextToken().toInt()
    val seg = IntArray(4 * n + 1) { 0 }
    val light = IntArray(n) { 0 }
    val str2 = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        light[i] = str2.nextToken().toInt()
    }
    fun init(node: Int, l: Int, r: Int) {
        if (l == r) {
            seg[node] = l
        } else {
            val mid = (l + r) / 2
            init(2 * node, l, mid)
            init(2 * node + 1, mid + 1, r)
            if(light[seg[2*node]]<= light[seg[2*node+1]]) {
                seg[node] = seg[2*node+1]
            } else seg[node] = seg[2*node]
        }
    }
    init(1, 0, n - 1)
    fun query (node:Int, start:Int, end:Int, l:Int, r:Int) :Int {
        if(start>r||end<l) {
            return -1
        } else if(l<=start && end<=r) {
            return seg[node]
        }
        else {
            val mid = (start+end)/2
            val m1 =query(2*node, start, mid, l, r)
            val m2 = query (2*node+1, mid+1, end, l,r)
            if(m1==-1) {
                return m2
            } else if(m2==-1) {
                return m1
            } else {
                if(light[m1]<=light[m2]) {
                    return m2
                } else {
                    return m1
                }
            }
        }
    }

    for(i in m-1 .. n-m) {
        bw.write("${light[query(1, 0, n-1, i-(m-1), i+(m-1))]} ")
    }
    bw.flush()
}