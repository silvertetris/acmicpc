

fun main() {
    val n = readln().toInt()
    //seive
    val prime = BooleanArray(1000000) {true}
    prime[0] = false
    prime[1] = false
    for(i in 2..999999) {
        if(prime[i]) {
            for(j in i*2..999999 step i) {
                prime[j] = false
            }
        }
    }
    /*
    #1. states/subproblems
    dp[i][j] = 첫 둘 저금통 i, j 일때 소수 나온 횟수
     */
    val dp = Array(n+1) {IntArray(n+1) {0} }
    //#2. Base Cases => 0
    for(i in 1.. n) {
        for(j in 1..n) {
            if(i==1 && j==1) continue//1, 1은 포함 안함
            val temp = (i.toString() + j.toString()).toInt()
            //#3. transition
            if(prime[temp]) {
                dp[i][j] = maxOf(dp[i-1][j], dp[i][j-1]) + 1
            }
            else {
                dp[i][j] = maxOf(dp[i-1][j], dp[i][j-1])
            }
        }
    }
    //#4. final answer
    print(dp[n][n])
}