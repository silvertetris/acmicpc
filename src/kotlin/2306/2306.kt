fun main() {
    val s = readln()
    /*
    #1. states/ subproblems
    dp[i][j] = i인덱스 부터 j 인덱스까지 최대 길이
    안쪽에서부터 바깥쪽으로 늘리면서 최대값을 확인하는 방식 -> 길이 최대 500 -> O(n^2) 해도 문제 없음
     */
    val dp = Array(s.length + 1) { IntArray(s.length + 1) { 0 } }
    /*
    #2. Base Cases
    처음에는 길이로 하려다가 그런식이면 아닌 조건을 찾아서 차감하는 식으로 해야함
    -> 그리디 느낌나고 너무 복잡함
    0에서 부터 조건 맞으면 늘리는 식으로 함
     */
    //at, gc
    //#3. transition
    for (i in 1 until s.length) {//우측부분
        for(j in i-1 downTo 0) {//좌측부분
            if((s[j] == 'a' && s[i] == 't') || (s[j] == 'g' && s[i] == 'c')) {
                dp[j][i] = dp[j+1][i-1] +2 //안쪽에서 바깥쪽으로 조건 만족시
            }
            for(k in j until i) { //좌 기준값에서 기존 dp 보다 큰 값이 있는지 최신화 (바깥에서 안쪽으로 확인)
                dp[j][i] = maxOf(dp[j][i], dp[j][k] + dp[k+1][i])
            }
        }
    }
    //#4. final answer
    print(dp[0][s.length-1])
}
