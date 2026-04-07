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
    segtree = 연속된거 같은건 0, 아닌건 변화한걸 인덱스 저장
    0~n-1 탐색

     */
    val str = StringTokenizer(br.readLine())
    val a = IntArray(n)
    for(i in 0 until n) {
        a[i] = str.nextToken().toInt()
    }
    val seg = IntArray(4*n+1) {0}
    fun init(node:Int, l:Int, r:Int) {
        if(l==r) {
            if(l>0 && a[l]!=a[l-1]) {
                seg[node] = l//여기에 어떤걸 저장해야하나?
            } else {
                seg[node] = 0
            }
        }
        else {
            val mid = (l+r)/2
            init(2*node, l, mid)
            init(2*node+1, mid+1, r)
            seg[node] = maxOf(seg[2*node], seg[2*node+1])
        }
    }

    fun update(node:Int, l:Int, r:Int, idx:Int) {
        if(idx !in l..r) {
            return
        } else if (l==r) {
            if(l>0 && a[l]!=a[l-1]) {
                seg[node] = l
            } else {
                seg[node] =0
            }
        }
        else {
            val mid= (l+r)/2
            update(2*node, l, mid, idx)
            update(2*node+1, mid+1, r, idx)
            seg[node] = maxOf(seg[2*node] , seg[2*node+1])
        }
    }
    fun query(node:Int, start:Int, end:Int, l:Int, r:Int) :Int {
        if(start>r || end<l) {
            return -1
        }
        else if(l<=start && end<=r) {
            return seg[node]
        } else {
            val mid = (start+end)/2
            val m1 = query(2*node, start, mid, l, r)
            val m2 = query(2*node+1, mid+1, end, l, r)
            if(m1==-1) {
                return m2
            } else if(m2==-1) {
                return m1
            } else {//값을 찾는게 아니라 인덱스가 최신꺼인걸 찾아야하는거 아닌가?
                if(m1<=m2) {
                    return m2
                } else {
                    return m1
                }
            }
        }
    }
    init(1, 0, n-1)
    repeat(q) {
        val str2 = StringTokenizer(br.readLine())
        val num = str2.nextToken().toInt()
        if(num==1) {
            val idx = str2.nextToken().toInt()-1
            val cost = str2.nextToken().toInt()
            a[idx] = cost
            update(1, 0, n-1, idx)
            if(idx<n-1) update(1, 0, n-1, idx+1)
        } else {
            val idx = str2.nextToken().toInt()-1
            val res = query(1, 0, n-1, 0, idx)
            if(res==0) {
                bw.write("Spring\n")
            } else if(a[idx]>a[idx-1]) {
                bw.write("Summer\n")
            } else if(a[idx]<a[idx-1]){
                bw.write("Winter\n")
            } else {
                if(a[res] > a[res-1]){//a[res] = 변하는 지점 중에 최신 값에서 가장 큰 인덱스 의 값
                    //그니까 전꺼보다 변하는게 커짐? 근데 a[res] == a[res-1] 이면 어캄 아니지 그럴일은 없음 a[res-1]이랑 같으면 둘다 0이됨 -> a[res-1]이 작으니까 그 뒤에 오는게 더 크니까 여름 다음 가을
                    bw.write("Autumn\n")
                } else {
                    bw.write("Spring\n")
                }
            }

        }
    }
    bw.flush()
}