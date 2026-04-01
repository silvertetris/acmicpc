import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val line = br.readLine().split(" ")
    val n = line[0].toInt()
    val m = line[1].toLong()
    val x = LongArray(n)
    val str = StringTokenizer(br.readLine())
    for(i in 0 until n) {
        x[i] = str.nextToken().toLong()
    }
    val seg = IntArray(4*n+1) //min idx tree

    fun init(node:Int, l:Int, r:Int) {
        if(l==r) {
            seg[node] = l
        }
        else {
            val mid = (l+r)/2
            init(2*node, l, mid)
            init(2*node+1, mid+1, r)
            if(x[seg[2*node]]<x[seg[2*node+1]]) {
                seg[node] =seg[2*node]
            } else seg[node] = seg[2*node+1]
        }
    }

    fun query(node:Int, start:Int, end:Int, l:Int, r:Int) : Int {
        if(start>r || end<l) {
            return -1
        }
        else if(l<=start && end<=r) {
            return seg[node]
        }
        else {
            val mid = (start+end)/2
            val m1 = query(2*node, start, mid, l,r)
            val m2 = query(2*node+1, mid+1, end , l,r )
            if(m1==-1) {
                return m2
            } else if(m2==-1) {
                return m1
            } else {
                if(x[m1]<=x[m2]) {
                    return m1
                } else {
                    return m2
                }
            }
        }
    }
    val sorted = x.sorted()
    fun findCost (l:Int, r:Int) :Pair<Int, Long> {//streak, cost
        val minIdx = query(1, 0, n-1, l, r)
        var cost = x[minIdx]
        var remain =m
        //이분 탐색으로 바꾸기
        var low = 0
        var high = n
        while (low < high) {
            val mid = (low + high) / 2
            if (sorted[mid] <= cost) {//upperbound
                low = mid + 1
            } else {
                high = mid
            }
        }
        val count = low
        val streak = if (cost == 0L) count else minOf(count.toLong(), m / cost).toInt()

        var resStreak = streak
        var resCost = cost
        if (l < minIdx) {
            val temp = findCost(l, minIdx - 1)
            if (temp.first > resStreak) {
                resStreak = temp.first
                resCost = temp.second
            } else if (temp.first == resStreak) {
                resCost = minOf(resCost, temp.second)
            }
        }
        if (minIdx < r) {
            val temp = findCost(minIdx + 1, r)
            if (temp.first > resStreak) {
                resStreak = temp.first
                resCost = temp.second
            } else if (temp.first == resStreak) {
                resCost = minOf(resCost, temp.second)
            }
        }
        return resStreak to resCost
    }
    init(1, 0, n-1)
    val ans = findCost(0, n-1)
    if(ans.first==0) {
        print(0)
    } else{
        print(ans.second)
    }
}