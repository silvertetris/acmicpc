

fun main() {
    val a = readln()
    val b = readln()
    val dp = Array(1001) { IntArray(1001) { 0 } }
    for (i in 1 .. a.length) {
        for(j in 1 .. b.length) {
            if(a[i-1] == b[j-1]) {
                dp[i][j] = dp[i-1][j-1]+1 //같으면 +1
            }else {
                dp[i][j] = maxOf(dp[i-1][j], dp[i][j-1]) //같지 않으면
            }
        }
    }
    print(dp[a.length][b.length])
}