import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val(n, q) = br.readLine().split(" ").map{it.toInt()}
    /*
    봄 스타트
    알고리즘 수가 많으면 여름, 적으면 겨울
    같으면 전달이 여름이면 가을, 겨울이면 봄
    1 2 3 4 5 4 3 2 1
    1 2 3 5 2 7 4
    특정 idx를 가져온다 -> 왼쪽 오른쪽을 탐색한다
    큰 값이나 작은 값이 나오면 리턴한다
     */
    val str = StringTokenizer(br.readLine())
    val a = IntArray(n)
    for(i in 0 until n) {
        a[i] = str.nextToken().toInt()
    }
    val seg = IntArray(4*n+1) {0}
    fun init(node:Int, l:Int, r:Int) {
        if(l==r) {
            seg[node] = l//여기에 어떤걸 저장해야하나?
        }
        else {
            val mid = (l+r)/2
            init(2*node, l, mid)
            init(2*node+1, mid+1, r)
            if(a[2*node]<=a[2*node+1]) {
                seg[node] = seg[2*node+1]
            } else {
                seg[node] = seg[2*node]
            }
        }
    }

    fun update(node:Int, l:Int, r:Int, idx:Int, cost:Int) {
        if(idx !in l..r) {
            return
        } else if (l==r) {
            seg[node] = cost
        }
        else {
            val mid= (l+r)/2
            update(2*node, l, mid, idx, cost)
            update(2*node+1, mid+1, r, idx, cost)
            if(a[2*node] <= a[2*node+1]){
                seg[node] = seg[2*node+1]
            } else{
                seg[node] = seg[2*node]
            }
        }
    }

    repeat(q) {
        val str2 = StringTokenizer(br.readLine())
        val num = str2.nextToken().toInt()
        if(num==1) {
            val idx = str2.nextToken().toInt()-1
            val cost = str2.nextToken().toInt()
            a[idx] = cost
            update(1, 0, n-1, idx, cost)
        } else {

        }
    }
}