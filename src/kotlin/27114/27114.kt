fun main() {
    val (a, b, c, k) = readln().split(" ").map { it.toInt() }
    val turn = intArrayOf(a, b, c) // 좌로, 우로, 뒤로
    //a, b, c 횟수의 관계?
    //a, b는 %4, c는 %2함 -> abs(a-b)+ 2c = 4가 되면 만족
    /*
    #1. states/ subproblems
    dp[i][j] = j 방향을 바라볼 때, 체력 소모가 i 일때 최소 횟수
    0: 정면
    1: 우
    2: 후방
    3: 좌
     */
    val dp = Array(k+1) {IntArray(4) {Int.MAX_VALUE-100_000} }
    //#2. Base Cases
    dp[0][0] = 0
    //#3. transition
    for(i in 1.. k) {
        for(j in 0 until 4) {
            for (p in 0 until 3) {
                if(i-turn[p] < 0) {
                    continue
                }
                if(p == 0) { //좌로 돌기
                    dp[i][j] = minOf(dp[i][j], dp[i-turn[p]][(4+j-1)%4] + 1)
                }
                if(p==1) {
                    dp[i][j] = minOf(dp[i][j], dp[i-turn[p]][(j+1)%4]+1)
                }
                if(p==2) {
                    dp[i][j] = minOf(dp[i][j] , dp[i-turn[p]][(j+2)%4]+1)
                }
            }
        }
    }
    //#4. final answer
    if(dp[k][0] == Int.MAX_VALUE-100_000) {
        print(-1)
    }else {
        print(dp[k][0])
    }
}