fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val pages = BooleanArray(101) { false }
    val line = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    for (i in 0 until m) {
        pages[line[i]] = true
    }
    pages[0] = true
    /*
    #1. states/ subproblems
    dp[i] = i에서 종이가 없을때 총 잉크 수
     */
    val dp = IntArray(n + 1) { Int.MAX_VALUE - 100_000 }
    //#2. Base Cases
    dp[0] = 0
    //#3. transition
    for (i in 1..n) {
        if (pages[i]) {
            dp[i] = dp[i - 1]
        }
        //전파가 제대로 안되는 이유? -> 인덱스 시작과 끝을 제대로 확인
        for (j in 1..i) {
            val diff = i - j + 1
            dp[i] = minOf(dp[i], dp[j-1] + 5 + 2 * (diff))
        }

    }
    //#4. final answer
    print(dp[n])
}