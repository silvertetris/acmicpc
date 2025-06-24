fun main() {
    val br= System.`in`.bufferedReader()
    val(n, k) = br.readLine().split(" ").map { it.toInt() }
    val s = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val h = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    /*
    #1. states/ subproblems
    dp[i][j] = i구간에서 체력이 j 일 때 최대 점수
     */
    //#2. Base Cases -> 0 0에서 부터 시작
    val dp = Array(n+1) {IntArray(101) {0} }
    //#3. transition
    for(i in 1.. n) {
        for(j in 0 .. 100) {//100 부터 0 감소하려다가 감소 전파가 꼬여서 걍 0 부터 100 으로 함
            val maxi = if(j-k <0) 0 else j-k
            if(maxi + h[i-1] >100 ) {
                dp[i][j] = dp[i-1][maxi]
                continue
            }
            dp[i][j] = maxOf(dp[i-1][maxi], dp[i-1][maxi + h[i-1]] + s[i-1])
        }
    }
    //#4. final answer
    print(dp[n].max())
}