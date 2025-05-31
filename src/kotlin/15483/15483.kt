package kotlin.`15483`

fun main() {
    val br = System.`in`.bufferedReader()
    val a = br.readLine()
    val b = br.readLine()
    val dp = Array(a.length + 1) { IntArray(b.length + 1) }

    /*
    #1. states/ subproblems
    dp[i][j] = A 문자열 인덱스 i 일때 B문자열 j인덱스에서 만드는데 최소 횟수
     */

    /*
    #2. Base Cases
    dp[0][i] = A가 null 일때 B의 j인덱스 문자를 만드려면 그 만큼 삽입 해야함
    dp[i][0] = 동일하고 그 만큼 삭제
     */
    for(i in 0 .. b.length) dp[0][i] = i
    for(i in 0 .. a.length) dp[i][0] = i

    //#3. transitions
    for (i in 1..a.length) {
        for (j in 1..b.length) {
            if (a[i - 1] == b[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] //같으면 냅둠
            } else {
                dp[i][j] = minOf(dp[i - 1][j], dp[i][j - 1], dp[i-1][j-1]) +1 //추가, 삭제, 교체
            }
        }
    }

    //#4. final answer
    print(dp[a.length][b.length])
}