fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val s = br.readLine().toCharArray()
    /*
    #1. states/subproblems
    dp[i] = i까지 가는데 필요한 최소 값
     */
    val dp = IntArray(n+1) {Int.MAX_VALUE-100_0000}
    //#2. Base Case
    dp[0] = 0
    for(i in 0 until n-1) {
        val cur = s[i]
        for(j in i+1 until n) {
            val next = s[j]
            if(cur == 'B' && next =='O') {
                dp[j] = minOf(dp[i] + (j-i)*(j-i), dp[j])
            }
            else if(cur=='O' && next =='J') {
                dp[j] = minOf(dp[i] + (j-i)*(j-i), dp[j])
            } else if(cur=='J' && next =='B') {
                dp[j] = minOf(dp[i] + (j-i)*(j-i), dp[j])
            }
        }
    }
    if(dp[n-1] == Int.MAX_VALUE-100_0000) {
        print(-1)
    } else print(dp[n-1])
}