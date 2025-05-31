

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    while (true) {
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        if (n == 0 || k == 0) break
        val a = br.readLine().split(" ").map { it.toInt() }
        /*
        #1. states/ subproblems
        dp[i][j] = 인덱스 i를 j 번째에 골랐을 때 경우 의 수
         */

        val dp = Array(n + 1) { LongArray(k + 1) { 0 } }
        /*
        #2. Base Cases
        dp[i][1] = 1
        인덱스 i를 첫번째로 처음 골랐을 때 경우의 수 스타트 = 1
         */
        for(i in 0.. n) {
            dp[i][1] = 1
        }
        for(i in 2 .. n) {
            for( j in i-1 downTo 1) {
                // 증가하는 수열일 경우에만
                if(a[i-1]<=a[j-1]) {
                    continue
                }
                //#3. transitions
                for(p in 2 .. k) {
                    dp[i][p] += dp[j][p-1] //해당 수를 그 전에 골랐으면 당연히 증가하는 수열이 유지될 것이고 그 경우의 수를 추가한다.
                }
            }
        }
        //#4. final answer
        var result = 0L
        for(i in 1 .. n) {
            result+=dp[i][k] //각 수를 k 번째 (마지막) 에 선택했을 때 총 경우의 수 합
        }
        bw.write("${result}\n")
    }
    bw.flush()
}