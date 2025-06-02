import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val isPrime = BooleanArray( 100_001) { true }
    isPrime[0] = false
    isPrime[1] = false
    val primes = mutableListOf<Int>()

    fun seive(isPrime: BooleanArray, primes:MutableList<Int>) {
        for( i in 2..sqrt( 100_000.0).toInt()) {
            for(j in i*2.. 100_000 step i) {
                isPrime[j] = false
            }
        }
        for(i in 0 .. 100_000) {
            if(isPrime[i]) primes.add(i)
        }
    }

    seive(isPrime, primes)

    /*
    #1. states/ subproblems
    dp[i] = i 값을 소수로 나타낼 수 있는 경우의 수
     */
    val dp = IntArray(100_001) {0}
    //#2. Base Cases
    dp[0] = 1

    //#3. transition -> seive를 이용한 unbounded knapsack
    for (i in 0 until primes.size) {
        for (j in primes[i]..100_000) {
            dp[j] = (dp[j - primes[i]] +dp[j])%1_000_000_007
        }
    }

    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        //#4. final answer
        bw.write("${dp[n]}\n")
    }

    bw.flush()
    bw.close()
}
