fun main() {
    val br = System.`in`.bufferedReader()
    var (N, M) = br.readLine().split(" ").map { it.toInt() }

    val m = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val c = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    /*
    n개의 앱 A arr
각 m_i 만큼 메모리 사용
다시 실행하는데 드는 비용 -> C_i
몇개를 비활성화 시켜서 메모리 최소 M을 충당 해야함
M이상의 값에서 최소 C 값을 구해야함

dp[i] = i메모리에서 비활성화 시켰을 경우 최소 cost

거꾸로 생각하기 -> m 의 범위가 너무 커서 다 이터레이팅 하면 시간초과 무조건임
dp[i][j] = i인덱스에서 cost j 일때 메모리 값
     */
    /*
    #1. states/ subproblems
    dp[i][j] = i 인덱스에서 cost j 일 때 메모리 값
     */
    val dp = Array(N+1) {IntArray(10001) {0} }

    //#3. transition
    for(i in 1 .. N) {
        for(j in 0 .. 10000) {
            if(j<c[i-1]) {
                dp[i][j] = dp[i-1][j]
            } else {
                dp[i][j] = maxOf(dp[i-1][j], dp[i-1][j-c[i-1]]+m[i-1])
            }
        }
    }


    //#4. final answer
    for(i in 0 .. 10000) {
        if(dp[N][i]>=M) {
            print(i)
            return
        }
    }
}