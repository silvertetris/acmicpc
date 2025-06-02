fun main() {
    val br = System.`in`.bufferedReader()
    val(n, k) = br.readLine().split(" ").map { it.toInt() }
    val value = IntArray(n)

    for(i in 0 until n) {
        value[i] = br.readLine().toInt()
    }
    value.sort()

    /*
    #1. states/ subproblems
    dp[i] = i 값일 때 경우의 수
     */
    val dp = LongArray(k+1)
    //#2. Base Cases
    dp[0] = 1

    //#3. transitions -> unbounded knapsack
    for(i in 0 until n) {
        for(j in 1.. k) {
            if(j<value[i]) {
                continue
            }
            dp[j] += dp[j-value[i]]
        }
    }

    //#4. final answer
    print(dp[k])
}