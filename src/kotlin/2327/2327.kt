

fun main() {
    val br= System.`in`.bufferedReader()
    val (h, n) = br.readLine().split(" ").map { it.toInt() }
    val height = IntArray(n)
    val speed = IntArray(n)
    for(i in 0 until n) {
        val(a, b) = br.readLine().split(" ").map { it.toInt() }
        height[i] = a
        speed[i] = b
    }
    /*
    #1. states/ subproblems
    dp[i] = i높이 일때 최소 스피드
     */
    val dp = IntArray(h+1) {0}
    //#2. Base Cases
    dp[0] = Int.MAX_VALUE
    //#3. transition
    for(i in 0 until n) {
        for(j in h downTo height[i]) { //음수 인덱스 나오기 방지
            dp[j] = maxOf(dp[j], minOf(dp[j-height[i]], speed[i]))//여태 했던 높이 현재 높이 j 연산, 골랐을 때 (그 전 dp, 골르는 놈 속도)
            //제일 속도가 느린놈 중에 최대 고르기
        }
    }

    //#4. final answer
    print(dp[h])
}