import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val strA = StringTokenizer(br.readLine())
    val strB = StringTokenizer(br.readLine())
    val a = IntArray(n)
    val b= IntArray(n)
    for(i in 0 until n) {
        a[i] = strA.nextToken().toInt()
    }
    for(i in 0 until n) {
        b[i] = strB.nextToken().toInt()
    }
    val segA = IntArray(4*n+1)
    val segB = IntArray(4*n+1)
    fun init(node:Int, l:Int, r:Int, tree:IntArray, arr: IntArray) {
        if(l==r) {
            tree[node] = l
        } else {
            val mid = (l+r)/2
            init(2*node, l, mid, tree, arr)
            init(2*node+1, mid+1, r, tree, arr)
            if(arr[tree[2*node]] <= arr[tree[2*node+1]]) {
                tree[node] = tree[2*node]
            }
            else {
                tree[node] = tree[2*node+1]
            }
        }
    }
    fun query(node:Int, start:Int, end:Int, l:Int, r:Int, tree:IntArray, arr:IntArray) :Int {
        if(start>r || end<l) {
            return -1
        }
        else if(start>=l && end<=r) {
            return tree[node]
        } else {
            val mid = (start+end)/2
            val m1 = query(2*node, start, mid, l, r, tree, arr)
            val m2 = query(2*node+1, mid+1, end, l, r, tree, arr)
            if(m1==-1) {
                return m2
            } else if(m2==-1) {
                return m1
            }
            else {
                if(arr[m1]<=arr[m2]) {
                    return m1
                } else {
                    return m2
                }
            }
        }
    }
    init(1, 0, n-1, segA, a)
    init(1, 0, n-1, segB, b)
    /*
    0..n-1 까지 탐색했다가
    서로 구간의 최소값의 인덱스가 다르다.
    -> m1의 최소값을 점차 늘리면서, m2의 구간을 맞춘다? -> O(n^2)의 가능성이 있지 않나?

    인덱스가 같으면 -> 그걸 기준으로 양옆으로 펼침 -> 겹치지 않는 지점까지
    만약 같이 않다면? 그 사이를 쪼개서 찾아야겠지 -> 완벽하게 겹친다면? 쪼개서 오히려 숫자를 늘림

    0부터 구간 기준으로
    -> 끝지점에서의 query가 같으면 -> 우측 확장
    아니면 포기하고 다음 구간 찾기
     */
    fun idxCheck(l: Int, r: Int): Boolean {
        /*
        stackoverflow 걸리는 이유?
        m1 무한호출 ? -> 범위 -> 이탈시 예외
         */
        if(l>r) return true
        val m1 = query(1, 0, n - 1, l, r, segA, a)
        val m2 = query(1, 0, n - 1, l, r, segB, b)

        if (m1 != m2) return false

        return idxCheck(l, m1 - 1) && idxCheck(m1 + 1, r)
    }

    var ans = 0
    var idx = 0

    while (idx < n) {
        var low = idx
        var high = n - 1
        var max = idx
        while (low <= high) {
            val mid = (low + high) / 2

            if (idxCheck(idx, mid)) {
                max = mid
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        ans++
        //최대 우측확장 통과 -> 다음 구간 (포기하고 다음 구간 찾기)
        idx = max + 1
    }
    print(ans)
}