fun main() {
    val br =System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val sum = n*(n+1) / 2
    /*
    #1. states/ subproblems
    dp[i] = 합이 i 일 때 나올 수 있는 경우의 수
     */
    val dp = LongArray(sum/2 +1) {0}
    if(sum%2 !=0) { // 결국에 합이 홀수면 양쪽에 같이 둘 수가 없음
        print(0)
        return
    }
    //#2. Base Cases
    dp[0] = 1
    //#3. transition
    for(i in 1..n) {
        for( j in sum/2 downTo 1) { //결국 한쪽만 구하면 됨 양쪽 같으니까 합이
            if(i>j) continue
            dp[j] += dp[j-i]
        }
    }

    //#4. final answer
    print(dp[sum/2]/2) //왜 곱하기 2가 아니라 나누기 2냐 ->모든 수에 대한 경우의 수임 -> 양쪽에 같게 두려면 반은 선택하지 않은 수로 반대쪽에 넣기 때문
}