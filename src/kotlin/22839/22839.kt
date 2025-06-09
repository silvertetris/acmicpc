fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val dp = IntArray(301) {0}
    // 1, 4, 9, 16, 25,.. 최대 289 (17^2)

    dp[0] = 1
    for(i in 1.. 17) { //순서가 달라도 중복이 아니까 코인을 기준으로 해야함
        for(j in i*i..300) {
            dp[j] += dp[j-i*i]
        }
    }

    while(true) {
        val n = br.readLine().toInt()
        if(n == 0) {
            break
        }
        bw.write("${dp[n]}\n")
    }
    bw.flush()
    bw.close()
}