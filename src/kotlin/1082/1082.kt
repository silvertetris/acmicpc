fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val p = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt()
    /*
    #1. states/ subproblems
    dp[i] = i가치 일때 최대 값
     */
    val dp = Array(m+1) {""}
    //#3. transition -> unbounded knapsack
    for(i in 1.. m) {
        for(j in 1 .. n) {
            if(i<p[j-1]){
                continue
            }
            val temp = dp[i-p[j-1]]+"${j-1}".toCharArray().sortedDescending().joinToString("")
            val temp2 = dp[i].toCharArray().sortedDescending().joinToString("")
            if((temp.length>temp2.length)&&temp[0] != '0') { //맨앞에 0이아니여야함
                dp[i] = temp
                continue
            }else if(temp.length<temp2.length && temp2[0] !='0') {
                dp[i] = temp2
                continue
            }
            else {
                dp[i] = maxOf(temp, temp2)
            }
        }
    }
    //이 예외 처리가 중요했음 다 0만 고르는 경우만 있을 경우 0000000000000 이따구로 출력됨 그래서 이거 넣어서 맞음
    //#4. final answer
    if(dp[m][0] == '0' && dp[m][dp[m].lastIndex] == '0') {
        print(0)
    }
    else {
        print(dp[m])
    }
}