fun main() {
    val br = System.`in`.bufferedReader()
    val str = StringBuilder()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val watt = br.readLine().split(" ").map { it.toInt() }.toIntArray().sorted()
    /*
    #1. states/ subproblems
    dp[i] = 전체값 i 에 대하여 표현 min 개수
    -> 표현 불가능 하면 0 이고 가능하면 0 이 아닌 다른 값이 나옴 -> 이것이 경우의 수
     */
    val dp = IntArray(500*100+1) {Int.MAX_VALUE-100000}
    //#2. Base Cases -> 0은 표현 못함
    dp[0] = 0
    //#3. transition
    for(i in 1.. n) {
        for(j in 50000 downTo watt[i-1] ) {//위부터 아래로 전파 -> 오염되지 않은 INF, 하위 값에 영향을 받지 않음, ex) dp[watt[i]]일때 1이 나와야함
            dp[j] = minOf(dp[j], dp[j-watt[i-1]]+1)
        }
    }
    //#4. final answer
    var cnt= 0
    for(i in 0 until 50001) {
        if(dp[i] in 1.. k) {
            cnt++
            str.append(i).append(" ")
        }
    }
    println(cnt)
    print(str.toString().trim())
}