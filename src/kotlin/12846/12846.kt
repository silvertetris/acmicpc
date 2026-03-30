import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val t = IntArray(n)
    val str = StringTokenizer(br.readLine())
    for(i in 0 until n) {
        t[i] = str.nextToken().toInt()
    }
    br.close()
    val seg = IntArray(4*n+1) {0}
    fun init(node:Int, left:Int, right:Int) {
        if(left==right) {
            seg[node] = left
        }
        else {
            val mid = (left+right)/2
            init(2*node, left, mid)
            init(2*node+1, mid+1, right)
            if(t[seg[2*node]]<=t[seg[2*node+1]]) {
                seg[node] = seg[2*node]
            } else {
                seg[node] = seg[2*node+1]
            }
        }
    }
    fun query(node:Int, start:Int, end:Int, l:Int, r:Int):Int {
        if(start>r || end<l) {
            return -1
        }
        if(l<=start && end<=r) {
            return seg[node]
        }
        val mid = (start+end)/2
        val m1 = query(2*node, start, mid, l, r)
        val m2 = query(2*node+1, mid+1, end, l, r)
        if(m1==-1) return m2
        else if(m2==-1) return m1
        else {
            if(t[m1]<=t[m2]) {
                return m1
            }
            else return m2
        }
    }

    fun largest (start:Int, end:Int):Long {
        val m = query(1, 0, n-1, start, end)
        var sal = (end-start+1)*t[m].toLong()
        if(start<=m-1) {
            val temp = largest(start, m-1)
            sal = maxOf(sal, temp)
        }
        if(m+1<=end) {
            val temp = largest(m+1, end)
            sal = maxOf(sal, temp)
        }
        return sal
    }

    init(1, 0, n-1)
    print(largest(0, n-1))
}