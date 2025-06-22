fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val n = br.readLine().toInt()
    repeat(n) {
        val (limit, year) = br.readLine().split(" ").map { it.toInt() }
        val d = br.readLine().toInt()
        val money = IntArray(d)
        val interest = IntArray(d)
        for (i in 0 until d) {
            val temp = br.readLine().split(" ").map { it.toInt() }
            money[i] = temp[0]
            interest[i] = temp[1]
        }
        /*
        #1. states/ subproblems
        dp[i]= i년 년차일때, 최대 자산
         */
        val dp = IntArray(year+1) {0}
        dp[0] = limit
        for(i in 1 .. year) {
            dp[i] = dp[i-1]
            for(j in 1 .. d) {
                if(dp[i-1] - money[j-1]>=0) {
                }
            }
        }
    }
}