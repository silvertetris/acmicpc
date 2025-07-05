fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    val dp = IntArray(101) { 0 }
    for (i in 1..100) { //미리 1~100수를 1, 10, 25로 표현하는 최소 경우의 수
        dp[i] = dp[i-1] +1
        if(i-10>=0) dp[i] = minOf(dp[i], dp[i-10]+1)
        if(i-25>=0) dp[i] = minOf(dp[i], dp[i-25]+1)
    }
    repeat(t) {
        var n = br.readLine().toLong()
        var ans = 0L
        while(true) {
            if(n==0L) break
            val mod = n%100//최 하위 2개 자리수 -> 최소값 더하고
            ans+= dp[mod.toInt()]
            n/=100 //점점 줄임
        }
        bw.write("${ans}\n")
    }
    bw.flush()
    bw.close()
}