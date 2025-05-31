package kotlin.`1660`

fun main() {
    val n = readln().toInt()
    //#1. states / subproblems = dp[i] = 대포알 개수가 i 일때 최소 개수
    val dp = IntArray(n + 1) { Int.MAX_VALUE - 1_000_000 }
    val cannon = IntArray(125)
    val a = IntArray(125)

    //#2. Base Cases
    dp[0] = 0
    dp[1] = 1
    //각 정삼각형으로 정사면체 대포알 구하기
    for (i in 1..124) {
        cannon[i] = cannon[i - 1] + i
        a[i] = a[i - 1] + cannon[i]
    }


    //#3. transition
    for (j in 0..n) {
        for (i in 1..124) {
            if (j + a[i] <= n) {
                dp[j + a[i]] = minOf(dp[j + a[i]], dp[j] + 1)
            }
        }
    }
    //#4. final answer
    print(dp[n])
}