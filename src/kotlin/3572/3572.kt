import kotlin.math.cos

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (h, w, n) = br.readLine().split(" ").map{it.toInt()}
    val widths = IntArray(n)
    for(i in 0 until n) {
        widths[i] = br.readLine().toInt()
    }
    /*
    그리디로 풀면
    빈칸 만들고 하나의 width값 당 모든 h칸들을 탐색해야하니까 n^2 ->이걸 세그트리로 어떻게 최적화 시키지?
    1. sum들
    -> 이 아니라 그리디를 세그트리로 전환한다는 마인드면
    남은 자리를 세그트리로 저장하면 되는거 아님?? 그리고 update
    그니까 h가 최대 넣을 수 있는 칸이고
    w가 각 칸의 limit -> 인덱스말고 걍 합 세그트리로
    2. 합으로하면 어떻게 각 인덱스를 파악함? -> 최대 인덱스 느낌으로 최대 값들을 루트로 올리면?

     */
    val sizeIdx = minOf(h, n)
    val remains = IntArray(sizeIdx) {w}
    val seg = LongArray(4*sizeIdx+1)
    fun init (node:Int, l:Int, r:Int) { //#1.
        if(l==r) {
            seg[node] = w.toLong()
        }
        else {
            val mid =(l+r) /2
            init(2*node, l, mid)
            init(2*node+1, mid+1, r)
            seg[node] = maxOf(seg[2*node], seg[2*node+1])
        }
    }

    fun update(node:Int, l:Int, r:Int, idx:Int, cost:Int) {//idx에 cost로 바꾸고 다시 재정렬
        if(idx !in l..r) {
            return
        }
        else if(l==r) {
            seg[node] = cost.toLong()
        }else {
            val mid = (l+r)/2
            update(2*node, l, mid, idx, cost)
            update(2*node+1, mid+1, r, idx, cost)
            seg[node] = maxOf(seg[2*node], seg[2*node+1])
        }
    }

    fun query(node:Int, l:Int, r:Int, cost:Int) :Int { //여기서 tle 걸리는듯 함
        if(seg[node]<cost) {
            return -1
        } else if(l==r) {
            return l
        } else {
            val mid = (l+r)/2
            if(seg[2*node] >=cost) {
                return query(2*node, l, mid, cost)
            } else {
                return query(2*node+1, mid+1, r, cost)
            }
        }
    }
    init(1, 0, sizeIdx-1)
    for(i in 0 until n) {
        val temp = query(1, 0, sizeIdx-1, widths[i])
        if(temp!=-1) {
            bw.write("${temp+1}\n")
            update(1, 0, sizeIdx-1, temp, remains[temp] - widths[i])
            remains[temp] -= widths[i]
        } else {
            bw.write("-1\n")
        }
    }
    bw.flush()
}