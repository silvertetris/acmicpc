package kotlin.`1028`

fun main() {
    val br = System.`in`.bufferedReader()
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val lArr = Array(r) { IntArray(c) { 0 } }
    val rArr = Array(r) { IntArray(c) { 0 } }
    for (i in 0 until r) {
        val temp = br.readLine()
        for (j in 0 until c) {
            lArr[i][j] = temp[j] - '0'
            rArr[i][j] = temp[j] - '0'
        }
    }
    /*
    ldp[i][j] = left-bottom 에서 right-top 으로 그은 대각선의 최대 길이
    rdp[i][j] = right-botton 에서 left-top 으로 그은 대각선의 최대 길이
     */
    for (i in r - 2 downTo 0) {
        for (j in 0 until c) {
            if (lArr[i][j] == 1 && j != 0) {
                lArr[i][j] += lArr[i + 1][j - 1]
            }
            if (rArr[i][j] == 1 && j != c - 1) {
                rArr[i][j] += rArr[i + 1][j + 1]
            }
        }
    }
    var ans = 0
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (lArr[i][j] != 0 && rArr[i][j] != 0) {
                ans = maxOf(ans, 1)//최소 둘다 1임
                if (lArr[i][j] != 1 && rArr[i][j] != 1) { //1보다 클 경우
                    val n = minOf(lArr[i][j], rArr[i][j])//대각선 최대치 (max(minOf))
                    for (k in n downTo 1) {
                        if (lArr[i + k - 1][j + k - 1] >= k && rArr[i + k - 1][j - k + 1] >= k) { //다이아몬드가 되는 확인 조건
                            //lArr 에서 우측 대각선 확인하기 ( 최종 도달 최대 값이 만족하는지), rArr에서 좌대각선 확인하기
                            ans = maxOf(ans, k) //final answer
                        }
                    }
                }
            }
        }
    }
    print(ans)
}