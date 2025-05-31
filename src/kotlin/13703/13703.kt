package kotlin.`13703`

/*
k cm 아래에서 1초마다 50% 확률로 위 아니면 아래로 1cm 이동함.

다 올라오면 먹혀 없어짐
n 초후에 생존할 확률이 S/2^n 일때 S 값 구하기

모든 경우의 수중에서 도합 K 수정할때 0이상이 되지 않으면 확률에 포함시킴
N초일때 모든 상황의 경우의 수 분에 넘지 않은 것 -> S/2^n임

일단 N 초일때 모든 경우의 수는 ??
2^n
 */

fun main() {
    val (k, n) = readln().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { LongArray(150) { 0 } }

    /*
    #1. states/subproblems
    dp[i][j] = i초 일때 수심이 j일떄 경우의 수
     */
    //#2. Base Cases
    dp[0][k] = 1

    //#3. transition
    for (i in 1..n) {
        for (j in 1 until 149) { //모든 수심 위치에 대해서 경우의 수를 계산해줌
            if(j>1) { //수면에 닿자마자 뒤지니까 j가 1일때 수심 0미터인건 더하면 안되지
                dp[i][j] = dp[i-1][j-1]
            }
            dp[i][j] += dp[i-1][j+1] //더 깊이들어가는건 상관 없음
        }
    }
    var answer = 0L

    //#4. final answer
    for (i in 1 until 149) {
        answer += dp[n][i] //n초일때 모든 경우의 수를 더함
    }
    print(answer)
}