package kotlin.`9465`

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val arr = Array(2) {IntArray(n)}
        for(i in 0 until 2) {
            arr[i] = br.readLine().split(" ").map{it.toInt() }.toIntArray()
        }
        val dp = Array(2) { IntArray(n) }
        //1. state/subproblems
        //각 위치에 따른 최대값 구하기
        //2. baseCase
        dp[0][0] = arr[0][0]
        dp[1][0] = arr[1][0]
        //3. transition
        for(i in 1 until n) {
            dp[0][i] = arr[0][i] + maxOf(dp[1][i-1], if(i>1)dp[1][i-2] else 0) //2. baseCase 로 침., i 가 1일때 예외가 있음
            dp[1][i] = arr[1][i] + maxOf(dp[0][i-1], if(i>1)dp[0][i-2]else 0)
        }
        //4. final answer
        bw.write("${maxOf(dp[0][n-1], dp[1][n-1])}\n")
    }
    br.close()
    bw.flush()
    bw.close()
}