fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }//남은기간, 챕터 수
    val arr = Array(m) {0 to 0} // 일수 , 챕터
    for(i in 0 until m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        arr[i] = temp[0] to temp[1]
    }
    arr.sortByDescending { it.second }

    val dp = IntArray(n+1) {0}
    for(i in 0 until m) {
        for(j in n downTo arr[i].first) {
            dp[j] = maxOf(dp[j], dp[j-arr[i].first] + arr[i].second)
        }
    }
    print(dp[n])
}