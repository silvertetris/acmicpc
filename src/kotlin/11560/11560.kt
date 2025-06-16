fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    /*
    #1. states/ subproblems
    dp[i][j] = 최대 계수가 i 승일 때, j 승인 것의 계수
     */
    val dp = Array(21) { LongArray(211) {0} }
    //#2. Base Cases
    for(i in 0 until 21) {
        dp[i][0] = 1 //모든 0승인 다항식의 계수는 1임
    }
    dp[1][1] = 1
    //항의 수 -> 2, 2, 4, 7, 10, 15 .... 1+2+3+4+5 느낌으로 늘어남
    //#3. transition
    for(i in 2 .. 20) {
        val limit = i*(i+1)/2
        if (limit % 2 == 0) {
            for (j in 1 .. limit/2) {
                // i차항까지 포함된 (1 + x + … + x^i) 곱셈: j차항은 j-i 부터 j 까지 더함
                val start = maxOf(0, j - i)
                for (k in start .. j) {
                    dp[i][j] += dp[i-1][k] //그전의 계수들의 합임
                }
            }
            // k가 3이면  계수 순서가 -> 1, 3, 5, 6, 5, 3, 1 이 됨
            for (j in limit/2+1 .. limit) { //대칭이니까 뒤쪽도 똑같이 해줌
                dp[i][j] = dp[i][limit-j]
            }
        } else {
            for (j in 1 .. limit/2 + 1) {
                // i차항까지 포함된 (1 + x + … + x^i) 곱셈: j차항은 j-i 부터 j 까지 더함
                val start = maxOf(0, j - i)
                for (k in start .. j) {
                    dp[i][j] += dp[i-1][k] //그전의 계수들의 합임
                }
            }
            // k가 3이면  계수 순서가 -> 1, 3, 5, 6, 5, 3, 1 이 됨
            for (j in limit/2 + 2 .. limit) { //대칭이니까 뒤쪽도 똑같이 해줌
                dp[i][j] = dp[i][limit-j]
            }
        }
    }

    //#4. final answer
    repeat(t) {
        val (k, n) = br.readLine().split(" ").map { it.toInt() }
        bw.write("${dp[k][n]}\n")
    }
    bw.flush()
    bw.close()
}
