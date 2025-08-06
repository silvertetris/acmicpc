fun main() {
    val br = System.`in`.bufferedReader()
    val(n, m) = br.readLine().split(" ").map { it.toInt() }
    val bridge = Array(n) {BooleanArray(m) {false} }
    for(i in 0 until n) {
        val temp = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        for(j in 0 until m) {
            if(temp[j]==1) {
                bridge[i][j] = true
            }
        }
    }
    if(m==1) {
        var cnt = 0
        for(i in 0 until n) {
            if(bridge[i][0]) {
                cnt++
            }
        }
        if(cnt!=n) {
            print(0)
        } else {
            print(1)
        }
        return
    }
    val dp = Array(n) { LongArray(m) {0} }
    for(i in 0 until m) {
        if(bridge[0][i]) {
            dp[0][i] = 1
        }
    }
    for(i in 1 until n) {
        for(j in 0 until m) {
            if(bridge[i][j]) {
                if(j==0) {
                    dp[i][j] +=dp[i-1][j] + dp[i-1][1]
                }
                else if(j==m-1) {
                    dp[i][j] += dp[i-1][j-1]+ dp[i-1][j]
                }
                else {
                    dp[i][j] += dp[i-1][j-1] + dp[i-1][j] + dp[i-1][j+1]
                }
                dp[i][j]%=1_000_000_007L
            }
        }
    }
    var result = 0L
    for(i in 0 until m) {
        result = (result + dp[n-1][i])%1_000_000_007
    }
    print(result)
}