fun main() {
    val br = System.`in`.bufferedReader()
    val(n, m) = br.readLine().split(" ").map{ it.toInt() }
    val arr = Array(n) { IntArray(m)  }
    for(i in 0 until n) {
        arr[i] = br.readLine().split(" ").map{ it.toInt() }.toIntArray()
    }
    val h = br.readLine().toInt()

    val dp  = Array(n+1) {LongArray(m+1) {0} }
    dp[0][0] = arr[0][0].toLong()
    for(i in 0 until n) {
        for(j in 0 until  m) {
            if(i==0 && j==0) {
                continue
            }
            else if(i == 0) {
                dp[i][j] = dp[i][j-1]+arr[i][j]
            } else if(j==0) {
                dp[i][j] = dp[i-1][j] + arr[i][j]
            } else {
                dp[i][j] = minOf(dp[i-1][j] + arr[i][j], dp[i][j-1] + arr[i][j])
            }
        }
    }
    if(dp[n-1][m-1]<=h) {
        println("YES")
        print(dp[n-1][m-1])
    } else {
        print("NO")
    }
}