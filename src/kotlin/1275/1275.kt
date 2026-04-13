import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, q) = br.readLine().split(" ").map{it.toInt()}
    val a =LongArray(n)
    val str = StringTokenizer(br.readLine())
    for(i in 0 until n) {
        a[i] = str.nextToken().toLong()
    }
    val seg = LongArray(4*n+1)
    fun init (node:Int, l:Int, r:Int) {
        if(l==r) {
            seg[node] = a[l]
        }
        else{
            val mid = (l+r)/2
            init(2*node, l, mid)
            init(2*node+1, mid+1, r)
            seg[node] = seg[2*node] + seg[2*node+1]
        }
    }

    fun update (node:Int, l:Int, r:Int, idx:Int, cost:Long) {
        if(idx !in l..r) {
            return
        } else if(l==r) {
            seg[node] = cost
        } else {
            val mid = (l+r)/2
            update(2*node, l, mid, idx, cost)
            update(2*node+1, mid+1, r, idx, cost)
            seg[node] = seg[2*node] + seg[2*node+1]
        }
    }

    fun sum(node:Int ,start:Int, end:Int, l:Int, r:Int) :Long {
        if(start>r|| end<l) {
            return 0
        } else if(l<=start && end<=r) {
            return seg[node]
        } else {
            val mid = (start+end)/2
            return sum(2*node, start, mid, l, r) + sum(2*node+1, mid+1, end, l, r)
        }
    }
    init(1, 0, n-1)
    for(i in 0 until q) {
        val str2 = StringTokenizer(br.readLine())
        val x = str2.nextToken().toInt()
        val y = str2.nextToken().toInt()
        val a = str2. nextToken().toInt()
        val b = str2.nextToken().toLong()
        bw.write("${sum(1, 0, n-1, minOf(x, y)-1, maxOf(x, y)-1)}\n")
        update(1, 0, n-1, a-1, b)
    }
    bw.flush()
}