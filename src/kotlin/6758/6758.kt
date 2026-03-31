fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val(n,m) = br.readLine().split(" ").map{it.toInt()}
    val size = 2 shl n-1
    val arr = IntArray(size)
    for(i in 0 until size) {
        arr[i] = br.readLine().toInt()
    }
    val seg = IntArray(4*size+1)
    fun init(node:Int, l:Int, r:Int) {
        if(l==r) {
            seg[node] = l
        }
        else {
            val mid = (l+r)/2
            init(2*node, l, mid)
            init(2*node+1, mid+1, r)
            if(arr[seg[2*node]] <=arr[seg[2*node+1]]) {
                seg[node] = seg[2*node+1]
            } else {
                seg[node] = seg[2*node]
            }
        }
    }
    fun update (node:Int, l:Int, r:Int, idx:Int,) {
        if(idx !in l..r) return
        else if(l==r) {
            seg[node] = l
        } else {
            val mid = (l+r)/2
            update(2*node, l, mid, idx)
            update(2*node+1, mid+1, r, idx)
            if(arr[seg[2*node]] <=arr[seg[2*node+1]]) {
                seg[node] = seg[2*node+1]
            } else {
                seg[node] = seg[2*node]
            }
        }
    }
    fun findRate(node:Int, l:Int, r:Int, idx:Int, depth:Int) :Int{
        if(idx==seg[node]) {
            return depth
        }
        else if(l==r) {
            return depth
        }
        else {
            val mid = (l+r)/2
            if(idx<=mid) {//왼쪽까지 포함이니까
                return findRate(2*node, l, mid, idx, depth+1) //mid 인덱스 까지 포함
            } else {
                return findRate(2*node+1, mid+1, r, idx, depth+1)
            }
        }
    }
    init(1, 0, size-1)
    repeat(m) {
        val line = br.readLine().split(" ")
        if(line[0] =="R") {
            arr[line[1].toInt()-1] = line[2].toInt()
            update(1, 0, size-1, line[1].toInt()-1)
        }
        else if(line[0] =="W") {
            bw.write("${seg[1]+1}\n")
        } else {
            bw.write("${n-findRate(1, 0, size-1, line[1].toInt()-1, 0)}\n")
        }
    }
    bw.flush()
    /*
    처음 실수한거:
    1. init에서 인자 2*node, 2*node+1제대로 전달안한거 -> 부모로 제대로 올려줘야함 그니까 000000이 출력되지
    2. n이랑 size랑 혼동함. 그니까 세그 트리가 전체 인덱스를 탐색못했음.
    틀린 이유:
    arr[idx] <=arr[seg[node]]
    이걸로 찾으면
    세그트리는 레벨이 나눠져 있는데, 이런식으로 찾으면 같거나 작으면 계속 탐색함
    단순히 주어진 인덱스 가지고 탐색하는게 안전하지 -> arr 인덱스 따로, segtree 인덱스들은 그냥 최대 최소 찾기용 -> 따로 인덱스를 분리해서 생각해야함
     */
}
