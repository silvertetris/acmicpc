

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val t = br.readLine().toInt()
    for(i in 1..t) {
        val n = br.readLine().toInt()
        //1. states/ subproblems
        val dp = Array(n) {IntArray(2) {0} }
        //2. Base Cases
        dp[0][0] = 1 //Doors 를 선택했을 경우
        dp[0][1] =1//Others 를 선택했을 경우
        //3. transition
        for(i in 1 until n) {
            dp[i][0] = dp[i-1][1] //전 단계에 DOORS를 선택했다면 others를 선택해야함
            dp[i][1] = dp[i-1][0] + dp[i-1][1] //전 단계에 others를 선택했다면 어떤것을 선택하든 상관없음
        }
        //4. final answer
        bw.write("Scenario ${i}:\n${dp[n-1][0] + dp[n-1][1]}\n\n")
    }
    bw.flush()
    bw.close()
}