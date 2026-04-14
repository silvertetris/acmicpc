import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, q) = br.readLine().split(" ").map{it.toInt()}
    val str = StringTokenizer(br.readLine())
    val a = IntArray(n)
    for(i in 0 until n) {
        a[i] = str.nextToken().toInt()
    }
    val seg= IntArray(4*n+1)
    /*
    다른 지점을 인덱스값을 직접 넣고, 아니면 0을 넣음
    아님 그럼 0005 00 8 이딴거 못찾음
    나눠진걸 어떻게 판별하지?
    일단 처음, 마지막은 무조건 새 구간
    자기 기준 이전 것만 확인하면 된데
    완전 연속 일치 구간? -> 다른 어떤 a의 연속 일치 구간에도 포함하지 않는다는 말은
    그냥 개수 숫자 같다서 포함된다는 말이 아니라, 그냥 인덱스 다르면 카운트++임
    문제 설명이 이상함
    같으면 1 다르면 0

    1 1 1 1 2 2 2 2
    1 7 1 1 2 2 2 2
    1 0 0 0 1 0 0 0
    1 1 1 0 1 0 0 0
    원래 1이고 앞이 같으면 0으로 바꾸고 바로 뒤도 확인
    아니 앞뒤 둘다 확인해야함
    아님 업데이트하면 그 이전것도 달라지니까 결과적으로 뒤까지 업데이트 됨
    대신 업데이트 시에, 앞뒤 둘다 봐야보게 해야하니까 해당, 뒤 인덱스 둘다 업뎃
     */
    fun init(node:Int, l:Int, r:Int) {
        if(l==r) {
            if(l==0) {
                seg[node] = 1
            } else {
                if(a[l-1]==a[l]) {
                    seg[node] = 0
                } else {
                    seg[node] = 1
                }

            }
        } else {
            val mid = (l+r)/2
            init(2*node, l, mid)
            init(2*node+1, mid+1, r)
            seg[node] = seg[2*node]+ seg[2*node+1]
        }
    }
    fun update(node:Int, l:Int, r:Int, idx:Int) {
        if(idx !in l..r) {
            return
        } else if(l==r) {
            if(l==0) {
                seg[node] = 1
            } else {
                if(a[l-1]==a[l]) {
                    seg[node] = 0
                } else {
                    seg[node] = 1
                }
            }
        }
        else {
            val mid = (l+r)/2
            update(2*node, l, mid, idx)
            update(2*node+1, mid+1, r, idx)
            seg[node] = seg[2*node]+seg[2*node+1]
        }
    }
    fun sum(node:Int, start:Int, end:Int, l:Int, r:Int) :Int {
        if(start>r || end<l) {
            return 0
        } else if(l<=start && end <=r) {
            return seg[node]
        }
        else {
            val mid = (start+end)/2
            return sum(2*node, start, mid, l, r) + sum(2*node+1, mid+1, end , l, r)
        }
    }
    init(1, 0, n-1)
    for(i in 0 until q) {
        val str2 = StringTokenizer(br.readLine())
        val num = str2.nextToken().toInt()
        if(num==1) {
            val idx = str2.nextToken().toInt()
            val cost = str2.nextToken().toInt()
            a[idx-1] = cost
            update(1, 0, n-1, idx-1)
            update(1, 0, n-1, idx)
        }
        else {
            var temp =0
            val u = str2.nextToken().toInt()-1
            val v = str2.nextToken().toInt()-1
            if(u!=0) {
                if(a[u-1] == a[u]) {
                    temp = 1
                }
            }
            bw.write("${sum(1, 0, n-1, u, v)+temp}\n")
        }
    }
    bw.flush()
}