fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    val k = br.readLine().toInt()//최대 사용 횟수
    //홀순이 start
    /*
    #1. state/subproblem
    dp[i] = i를 만드는데 필요한 최소 숫자 사용 횟수
     */
    val dp = IntArray(5_0000) {Int.MAX_VALUE-5_000}
    dp[0] = 0
    dp[1] = 1
    for(i in 2 until 5_0000) {
        for(j in 0 until n) {
            val add = arr[j]
            if(i-add>=0) {
                dp[i] = minOf(dp[i], dp[i-add]+1)
            }
        }
    }
    var ans = 0
    for(i in 0 until 5_0000) {
        if(dp[i]>k) {
            ans=i
            break
        }
    }
    if(ans%2==0) {
        print("holsoon win at $ans")
    }else {
        print("jjaksoon win at $ans")
    }
}