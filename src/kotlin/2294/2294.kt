

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val coin = IntArray(n)
    for(i in 0 until n) {
        coin[i] = br.readLine().toInt()
    }
    /*
    #1. states/ subproblems
    dp[i] = i의 value를 가지고 있을 때 최소 동전 갯수
     */
    val dp = IntArray(10001) {Int.MAX_VALUE-1}
    // #2. Base Case
    dp[0] = 0 //당연히 0원이면 동전도 0개임 무조건
    //#3. transition
    for(i in 0 until n) {
        for(j in coin[i] .. k) {
            dp[j] = minOf(dp[j],dp[j-coin[i]]+1) //선택하냐 마냐
        }
    }

    //#4. final answer
    if(dp[k] == Int.MAX_VALUE-1) {//딱 맞는 k 의 경우가 발견되지 않으면 Int.MaxValue
        print(-1)
    } else {
        print(dp[k])
    }
}