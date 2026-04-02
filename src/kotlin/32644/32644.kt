import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map{it.toInt()}
    val strP = StringTokenizer(br.readLine())
    val p = IntArray(n)
    val strK = StringTokenizer(br.readLine())
    for(i in 0 until n) {
        p[i] = strP.nextToken().toInt()
    }
    /*
    i=1 부터 시작
    W는 일단 모든 회원 가중치 만큼부터 시작
    W중에서 아무거나 선택하고 이걸 X_i
    그니가 i가 1부터 시작이면 이 아무거나 선택한거 자체를 X_1?
    그리고 이 랜덤하게 뽑힌 숫자? -> 그니까 이 숫자는 1부터 전체 사이즈중 아무 정수
    근데 이숫자가? 단첨권 인덱스의 당첨자와 다르면 i+1

    1*1, 2*2, 3*3.... 이 배열에서 순서있는거 뽑고 없애고 하는거 아님?
     */

    val seg = IntArray(4*n+1)
    //#1. states -> 각 회원의 응모권 수 -> 합
    fun init(node:Int, l:Int, r:Int) {
        if(l==r) {
            seg[node] =p[l]//인덱스말고 합
        } else {
            val mid = (l+r)/2
            init(2*node, l, mid)
            init(2*node+1, mid+1, r)
            seg[node] = seg[node*2] + seg[2*node+1]
        }
    }

    fun update(node:Int, l:Int, r:Int, idx:Int) {
        if(idx !in l..r) {
            return
        } else if (l == r) {
            seg[node] = 0
        } else {
            val mid = (l+r)/2
            update(2*node, l, mid, idx)
            update(2*node+1, mid+1, r, idx)
            seg[node] = seg[2*node] + seg[2*node+1]
        }
    }
    fun query(node:Int, start:Int, end:Int, l:Int, r:Int) :Int {
        if(l>end || r<start) {
            return 0
        }
        else if(l<=start && end<=r) {
            return seg[node]
        }
        else {
            val mid = (start+end)/2
            return query(2*node, start, mid, l, r) + query(2*node+1, mid+1, end, l, r)
        }
    }
    init(1, 0, n-1)
    for(i in 0 until m) {
        val temp = strK.nextToken().toInt()
        bw.write("${query(1, 0, n-1, 0, temp-1)} ")
        update(1, 0, n-1, temp-1)
    }
    bw.flush()
}