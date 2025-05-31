package kotlin.`11054`

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr:Array<Pair<Long, Long>> = Array(n) { Pair(0, 0) }

    for(i in 0 until n) {
        val temp = br.readLine().split(" ").map { it.toLong() }
        arr[i] = temp[0] to temp[1]
    }

    arr.sortWith(compareBy<Pair<Long, Long>> { it.second }.thenBy { it.first })
    var cnt = 1
    var prev = arr[0].second
    for(i in 1 until n) {
        if(arr[i].first>=prev) {
            cnt++
            prev = arr[i].second
        }
    }
    print(cnt)
    val a = br.readLine().split(" ").map { it.toInt() }
    /*
    #1. states/ subproblems
    dp[i] = i 인덱스에서 사이즈가 가장 큰 부분 수율
     */

    //#2. Base Cases
    val Ldp = IntArray(n) {1}
    val Rdp = IntArray(n) {1}

    //#3. transition : 제곱해도 10만개라 2중 for 문 시도해볼만함
    for(i in 0 until n) {
        for(j in 0 until i) {
            if(a[i]>a[j]) {
                Ldp[i] = maxOf(Ldp[i], Ldp[j] + 1)
            }
        }
    }
    for(i in n-1 downTo 0) {
        for(j in n-1 downTo i+1) {
            if(a[i]>a[j]) {
                Rdp[i] = maxOf(Rdp[i], Rdp[j] + 1)
            }
        }
    }
    var ans = 0
    //#4. final answer
    for(i in 0 until n) {
        ans = maxOf(ans, Ldp[i] + Rdp[i] -1)
    }
    print(ans)
}