fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    repeat(3) {
        val n = br.readLine().toInt()
        val coins = Array(n) {0 to 0} //value, count
        var sum = 0
        for(i in 0 until n) {
            val(a, b) = br.readLine().split(" ").map { it.toInt() }
            coins[i] = a to b
            sum += a* b
        }
        if(sum%2!=0) {
            bw.write("0\n")
        }else {
            /*
            #1. states/ subproblems
            dp[i][j] = i개의 코인으로 합 j값을 만들 수 있는지
             */
            val dp = Array(n+1) { BooleanArray(sum/2+1) {false} }
            //#2. Base Cases
            dp[0][0] = true
            //#3. transition
            for(i in 1.. n) {
                for(j in 0 .. sum/2) {
                    if(dp[i-1][j]) {//그 전 dp가 맞는지 -> 전파용
                        for(k in 0 .. coins[i-1].second) {
                            if(j+coins[i-1].first*k <= sum/2) {
                                dp[i][j+coins[i-1].first*k] = true //그전 dp 와 현재 index의 코인 value로 만들 수 있는지 -> 이미 그전에 true라면 해당 코인으로 이 값을 만들 수 있음
                            }
                        }
                    }
                }
            }
            //#4. final answer
            if(dp[n][sum/2]) {
                bw.write("1\n")
            } else{
                bw.write("0\n")
            }
        }
    }
    bw.flush()
    bw.close()
    br.close()
}