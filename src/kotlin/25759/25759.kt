fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.toIntArray()
    /*
    #1. states/ subproblems
    dp[i][j] = l, r구간의 최대 합
    ->의미 없는게 이전 구간의 구간 제곱 최대 합이 그 이후의 구간에 영향을 끼치지 않음 -> 결국 전체 제곱 합
    dp[i] = i값을 마지막으로 선택했을 때, 최대 합
    -> i가 이미 입력된 값임인 가정하에 연산
    -> 마지막으로 해당 값을 선택 했을 경우, 이전 연산에 대해 최대 값이 정해졌음으로 다시 연산을 하지 않아도 됨
     */
    val dp = LongArray(101) { Long.MIN_VALUE }
    //#2. Base Cases -> 첫 꽃 하나만 골랐을 경우  = 0
    dp[a[0]] = 0L

    //#3. transition
    for (i in 1 until n) { //각 꽃들 인덱스에 대해
        for (j in 1..100) { //각 마지막으로 선택한 값을 가정하여
            if (dp[j] >= 0) { //이미 입력된 값임을 가정 -> 지나오면서 입력되지 않은 값들을 채움
                val d = (a[i] - j).toLong()
                dp[a[i]] = maxOf(dp[a[i]], dp[j] + d * d) //이미 해당 값을 두는게 더 큰지, 이전값에 대해 연산을 진행했을 때 더 큰지
            }
        }
    }
    //#4. final answer
    println(dp.max())
}
