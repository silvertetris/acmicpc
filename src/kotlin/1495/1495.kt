fun main() {
    val br = System.`in`.bufferedReader()
    val(n, s, m) = br.readLine().split(" ").map { it.toInt() }//곡 개수, 시작 볼륨, 최대 볼륨
    val arr = br.readLine().split(" ").map{it.toInt()}.toIntArray()
    val dp = Array(n+1) { BooleanArray(m+1) {false} }
    dp[0][s] = true
    for(i in 1.. n) {
        for(j in 0 .. m) {
            if(dp[i-1][j]) {
                if(j+arr[i-1] <=m) {
                    dp[i][j+arr[i-1]] = true
                }
                if(j-arr[i-1] >=0) {
                    dp[i][j-arr[i-1]] = true
                }
            }
        }
    }
    for(i in m downTo 0) {
        if(dp[n][i]) {
            print(i)
            return
        }
    }
    print(-1)

}