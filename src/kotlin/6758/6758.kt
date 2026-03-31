fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val(n,m) = br.readLine().split(" ").map{it.toInt()}
    val size = 2 shl n-1
    val arr = IntArray(n)
    for(i in 0 until n) {
        arr[i] = br.readLine().toInt()
    }
    val seg = IntArray(4*size+1)
    fun init(node:Int, l:Int, r:Int) {
        if(l==r) {
            seg[node] = l
        }
        else {
            val mid = (l+r)/2
            init(node, l, mid)
            init(node, mid+1, r)
            if(arr[seg[2*node]] <=arr[seg[2*node+1]]) {

            }
        }
    }
}