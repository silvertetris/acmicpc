import java.util.StringTokenizer
import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, q) = br.readLine().split(" ").map{it.toInt()}
    val str = StringTokenizer(br.readLine())
    val c= LongArray(n)
    for(i in 0 until n) {
        c[i] = str.nextToken().toLong()
    }
    /*
    N명의 공연자들이 일렬로 서서 깃발을 흔듦
카리스마 정도 c_i
L번째 공연자부터 R번째 공연자 까지 깃발을 흔듦
두 포지션 사이 거리가 짝수면 왼쪽, 홀수면 오른쪽으로 흔듦 그리고 원위치
두 거리는 그냥 차이

     */
    val seg = LongArray(4*n+1) {0}
    fun init(node:Int, l:Int, r:Int) {
        if(l==r) {
            if(l%2==0){
                seg[node] = c[l]
            }else {
                seg[node] = -c[l]
            }
        } else {
            val mid = (l+r)/2
            init(2*node, l, mid)
            init(2*node+1, mid+1, r)
            seg[node] = seg[2*node] + seg[2*node+1]
        }
    }

    fun update(node:Int, l:Int, r:Int, idx:Int, cost:Long ) {
        if(idx !in l..r) {
            return
        } else if(l==r) {
            if(l%2==0) {
                seg[node] = c[l]+cost
            } else {
                seg[node] = -c[l]-cost
            }
        } else {
            val mid = (l+r)/2
            update(2*node, l, mid, idx, cost)
            update(2*node+1, mid+1, r, idx, cost)
            seg[node] = seg[2*node]+seg[2*node+1]
        }
    }
    fun sum(node:Int, start:Int, end:Int, l:Int, r:Int) :Long {
        if(start>r || end<l) {
            return 0
        } else if(l<=start && end<=r) {
            return seg[node]
        } else {
            val mid = (start+end)/2
            return sum(2*node, start, mid, l, r) + sum(2*node+1, mid+1, end, l, r)
        }
    }
    //3 1 10 1 5 9
    init(1, 0, n-1)
    for(i in 0 until q) {
        val str2 = StringTokenizer(br.readLine())
        val u = str2.nextToken().toInt()
        if(u==1) {
            val l = str2.nextToken().toInt()
            val r =str2.nextToken().toInt()
            bw.write("${abs(sum(1, 0, n-1, l-1, r-1))}\n")
        }
        else {
            val l = str2.nextToken().toInt()-1
            val cost = str2.nextToken().toLong()
            //여기서 틀림
            update(1, 0, n-1, l, cost)
            c[l]+=cost
        }
    }
    bw.flush()
}