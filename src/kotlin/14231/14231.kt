import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextLine().toInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = sc.nextInt()
    }
    val dp = IntArray(100001) { 0 }
    //dp[i] = 마지막으로 i크기의 상자를 골랐을 때, 넣을 수 있는 최대 상자 개수
    for (i in 0 until n) {
        val temp = a[i]
        for (j in 0 until temp) {
            dp[temp] = maxOf(dp[temp], dp[j] + 1)
        }
    }
    print(dp.max())
}