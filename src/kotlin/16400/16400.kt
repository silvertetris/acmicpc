package kotlin.`16400`

fun main() {
    val n = readln().toInt()
    val prime = BooleanArray(40001) { true }

    prime[0] = false
    prime[1] = false
    for (i in 2..40000) {
        for (j in i * i..40000 step i) {
            if (prime[i]) prime[j] = false
        }
    }
    /*
    가격 N인 물건
    소수끼리 더해서 N 이나오는 경우의 수

    #1. states/subproblems
    dp[i]= 값이 i일때 소수로 고를 수 있는 경우의 수
     */


    val dp = IntArray(n+1) {0}
    //#2. Base Cases
    dp[0] = 1
    //#3. transition
    for(i in 1 .. n) {
        for( j in i.. n) { // 음수 인덱스 방지
            if(prime[i]) {
                dp[j] = (dp[j] + dp[j-i])%123456789
            }
        }
    }

    //#4. final answer
    print(dp[n])
}