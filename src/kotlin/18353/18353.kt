fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp = IntArray(n+1) {Int.MAX_VALUE-100_000_00}
    dp[arr[0]] = 0
    // i-1 인덱스에서 작은놈을 열외해야함
    for(i in 1 until n) {
        for(j in 1 until i) {

        }
    }
}