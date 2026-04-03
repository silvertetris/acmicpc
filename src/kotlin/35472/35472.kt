import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val str = StringTokenizer(br.readLine())
    val a = IntArray(n)
    for(i in 0 until n) {
        a[i] = str.nextToken().toInt()
    }
    val seg = IntArray(4*n+1)

    /*
    제일 작은 part sequence idx 저장
    정확히 1이 나면 안됨 차이가
    -> 1이 나는 부분수열들을 나눔 -> 파티션 개념으로 나누고, 서로 잇기? 3초니까 O(nlogn)으로 만들어야함
     */
    fun init(node:Int, l:Int, r:Int) {
        if(l==r) {
            seg[node] = l
        } else{
            val mid = (l+r) /2
            init(2*node, l, mid)
            init(2*node+1, mid+1, r)
            if(a[seg[2*node]] <= a[seg[2*node+1]]) {
                seg[node] = seg[2*node]
            } else seg[node] = seg[2*node+1]
        }
    }

    fun query(node:Int, start:Int, end:Int, l:Int, r:Int)  :Int { //-> 왼 우 다음 작은 애 찾기
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
            }
            else if(m2==-1) {
                return m1
            } else {
                if(a[m1]<=a[m2]) {
                    return m1
                } else return m2
            }
        }
    }
    /*
    근데 작은애를 찾고, 1차이 이상이 나면 버리기?
     */
    fun findStreak(l:Int, r:Int, idx:Int) :Int {
        if(l==r) {

        }
        return r-l
    }
}