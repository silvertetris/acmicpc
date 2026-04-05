fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val b = IntArray(n)//자기보다 앞에 있는 애들중에 자기보다 큰 값을 가진 애들의 수
    for(i in 0 until n) {
        b[i] = br.readLine().toInt()
    }
    val seg = IntArray(4*n+1)
    val arr = IntArray(n+1) {it}
    /*
    arr B => A에 대한 permutation중에서 각 인덱스보다 작은 애들 중에 현 인덱스보다 큰 애들의 수
    arr A 를 구해야함
    1..n까지 있는 인덱스를 n까지 탐색
    -> tree init시에 arr과 arrB값에 따라 정렬
     */
    fun init(node:Int, l:Int, r:Int) {
        if(l==r) {
            seg[node] = l //인덱스를 저장
            /*
            그니까 자기 좌우에 갯수가 더 크면 우측으로 아니면 왼쪽으로
             */
        } else {
            val mid = (l+r) /2
            init(2*node, l, mid)
            init(2*node+1, mid+1, r)
            if(b[2*node+1] <= b[2*node]) {
                seg[node] = b[2*node+1]
            } else {
                seg[node] = b[2*node]
            }
        }
    }

    fun query(node:Int, start:Int, end:Int, l:Int, r:Int) :Int {
        if(start == end) {
            return seg[node]
        } else if(r<start || l>end) {
            return -1
        }
        else{
            val mid = (start+end)/2
            val m1 = query(2*node, start, mid, l, r)
            val m2 = query(2*node+1, mid+1, end, l, r)
            if(m1 == -1) {
                return m2
            } else if(m2==-1) {
                return m1
            } else {
                if(b[m1]<=b[m2]) {
                    return m1
                } else {
                    return m2
                }
            }
        }
    }


}