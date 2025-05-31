package kotlin.`23815`

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    /*
    #1. states/ subproblems
    dp[i][0] = 그냥 쭉 갔을 때 최대 값
    dp[i][1] = 한번 건너뛴 최대 값
     */
    val dp = Array(n + 1) { IntArray(2) { 0 } }
    //#2. Base Cases : 1명이 초기값
    dp[0][0] = 1
    dp[0][1] = 1
    var lastChance = false
    fun calculate(op1: Char, value1: Int, op2: Char, value2: Int, n: Int): Int { //계산 함수
        var first = -1
        var second = -1
        if (op1 == '+' || op1 == '*') {
            first = if (op1 == '+') value1 + n else value1 * n
        }
        if (op2 == '+' || op2 == '*') {
            second = if (op2 == '+') value2 + n else value2 * n
        }
        if (op1 == '-' || op1 == '/') {
            first = if (op1 == '-') n - value1 else n / value1
        }
        if (op2 == '-' || op2 == '/') {
            second = if (op2 == '-') n - value2 else n / value2
        }
        return maxOf(first, second)
    }
    for (i in 1..n) {
        val temp = br.readLine()
        val op1 = temp[0]
        val value1 = temp[1] - '0'
        val op2 = temp[3]
        val value2 = temp[4] - '0'

        //#3. transitions
        dp[i][0] = calculate(op1, value1, op2, value2, dp[i - 1][0])
        if(dp[1][0] <=0&&i==1) {
            lastChance = true
            dp[i][1] = 1
            continue
        }
        if(lastChance) {
            dp[i][1] = calculate(op1, value1, op2, value2, dp[i - 1][1])
        }
        else {
            dp[i][1] = maxOf(dp[i - 1][0], calculate(op1, value1, op2, value2, dp[i - 1][1]))
        }
        //#4. final answer
        if (dp[i][1] <= 0) {
            print("ddong game")
            return
        }
    }
    //#4. final answer
    print(maxOf(dp[n][1], dp[n][0]))
}