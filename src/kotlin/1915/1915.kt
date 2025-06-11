fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { BooleanArray(m)}
    val dp = Array(n+1) { IntArray(m+1) }
    for(i in 0 until n){
        val temp = br.readLine()
        for(j in 0 until m) {
            if(temp[j] == '0') {
                arr[i][j] = false
            } else {
                arr[i][j] = true
            }
        }
    }
    //이런거는 항상 최대 길이에서 다 모든 공통되는 조건이 맞아야 늚. 1028 다이아몬드 광산과 유사 문제
    for(i in 1 .. n) {
        for(j in 1 .. m) {
            if(arr[i-1][j-1]) {
                dp[i][j] = minOf(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) +1
                //n*m모두 확인 -> 한 길이라도 최대 길이와 맞지 않는다면 최소 길이가 됨 -> 정사각형 확인 조건
            }
            else {
                dp[i][j] = 0 //끊김
            }
        }
    }
    val ans = dp.maxOf { it.max() }
    print(ans*ans)
}