import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    while(true) {
        val str = StringTokenizer(br.readLine())
        val n = str.nextToken().toInt()
        if(n==0) {
            break
        }
        val h = IntArray(n)
        for(i in 0 until n) {
            h[i] = str.nextToken().toInt()
        }
        val seg = IntArray(4*n+1)
        fun init(node: Int, l: Int, r: Int) {
            if (l == r) {
                seg[node] = l
            }
            else {
                val mid = (l+r) /2
                init(2*node, l, mid)
                init(2*node+1, mid+1, r)
                if(h[seg[2*node]] <= h[seg[2*node+1]]) {
                    seg[node] = seg[2*node]
                } else seg[node] = seg[2*node+1]
            }
        }
        fun query(node:Int, start:Int, end:Int, l:Int, r:Int):Int {//l r 고정, start, end움직이며 찾기
            if(start>r || l>end) {
                return -1
            }
            else if(l<=start && end<=r) {//범위 안에 들어옴
                return seg[node]
            }
            else {
                val mid = (start+end)/2
                val m1 = query(2*node, start, mid, l, r)
                val m2 = query(2*node+1, mid+1, end, l, r)
                if(m1==-1) {
                    return m2
                } else if(m2==-1) {
                    return m1
                }
                else {
                    if(h[m1] <= h[m2]) {
                        return m1
                    } else {
                        return m2
                    }
                }
            }
        }

        fun largest(l:Int, r:Int) :Long {
            val m = query(1, 0, n-1, l, r)
            var curA = (r-l+1)*h[m].toLong()
            /*
            stackoverflow 이유:
            currentArea 계산시에 m==l and m==r 일때, query 무한 call
            -> stackoverflow
             */
            if(l<m) {
                curA = maxOf(curA, largest(l, m-1))
            }
            if(m<r) {
                curA = maxOf(curA, largest(m+1, r))
            }
            return curA
        }
        init(1, 0, n-1)
        bw.write("${largest(0, n-1)}\n")
    }
    bw.flush()
}