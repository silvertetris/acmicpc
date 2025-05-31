package kotlin.`2156`

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = IntArray(n)
    val dp = IntArray(n+1) {0}
    for(i in 0 until n) {
        arr[i] = br.readLine().toInt()
    }
    if(n==1) {
        print(arr[0])
        return
    }
    if(n==2) {
        print(arr[0]+arr[1])
        return
    }
    dp[0] = arr[0]
    dp[1] = arr[0]+ arr[1]
    dp[2] = maxOf(dp[0]+arr[2] , dp[1], arr[1]+arr[2])
    for( i in 3 until n) {
        dp[i] = maxOf(dp[i-3] + arr[i-1]+arr[i], dp[i-2] + arr[i], dp[i-1])
    }
    print(dp[n-1])
}