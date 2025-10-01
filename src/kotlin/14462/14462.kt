import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val left = IntArray(n)
    val right = IntArray(n)
    for(i in 0 until n) {
        left[i] = br.readLine().toInt()
    }
    for(i in 0 until n) {
        right[i] = br.readLine().toInt()
    }
    /*
    먼저 겹치는 조건
    i에서 j까지 연결 했을 때( 작은 i에서 큰 j)
    이후 큰 i에서 작은 j까지는 연결이 안됨 -> 횡단보도가 겹치니까
    그리고 고려해야할건 각 목초지에는 하나의 횡단보도만 연결 할 수 있다는 거임
    왼쪽 기준으로만 생각을 해본다면 2차원 dp일때 점화식을 어떻게 세우냐..,
    특정 고정값 예를들어 절댓값 조건을 만족한
    dp[2][4]가 있다고 쳤을 때
    iterating을 i먼저하고 j를 한다고 침
    그러면
    dp[2][4] = max(dp[작은i에서][해당j] , dp[2][4]) 그리고
    dp[2][4] = max(dp[
    역류할 경우는?
    그니까 큰i에서 작은 j로 그을 경우
    ->이보다 작은 i에서 해당 j까지는 그을 수 없음
    즉 조건은 -> 근데 이게 dp 전파하다가 겹치는데 이 로직이 가능하냐???
    1. 작은 i에서 같거나 큰 j로 그을 경우

    2. 큰 i에서 작은 j로 그을 경우
     */

    /*
    #1. states/ subproblems
    i idx에서 j idx까지 이었을 때 최대 횡단보도
     */
    val dp = Array(n) {IntArray(n) {0} }
    //#2. Base Cases
    for(i in 0 until n) {
        if(abs(left[0] - right[i])<=4) {
            dp[0][i] = 1
        }
        if(abs(left[i] - right[0])<=4) {
            dp[i][0] = 1
        }
    }

    //#3. transition
    for(i in 1 until n) {
        for(j in 1 until n) {
            if(abs(left[i]-right[j]) <=4) { //이러면 겹치는걸 안고려한거긴함
                dp[i][j] = maxOf(dp[i-1][j-1], dp[i][j]) +1
            } else {
                dp[i][j] = maxOf(dp[i-1][j-1], dp[i][j])
            }
        }
    }
    //#4. final answer
    var max = 0
    for(i in 0 until n) {
        max = maxOf(max, dp[i].max())
    }
    print(max)
}