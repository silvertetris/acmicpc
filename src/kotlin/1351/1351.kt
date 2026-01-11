fun main() {
    val (n, p, q) = readln().split(" ").map { it.toLong() }
    val dp = HashMap<Long, Long>()
    dp[0] = 1
    if(n==0L) {
        print (1)
        return
    }
    dp[1] = 2
    //분할정복?
    fun divc (n:Long, p:Long, q:Long) : Long {
        val a = n / p
        val b = n/q
        var tempA = 0L
        var tempB = 0L
        if(!dp.containsKey(a)) {
            tempA = divc(a, p, q)
        } else {
            tempA = dp[a]!!
        }
        if(!dp.containsKey(b)) {
            tempB = divc(b, p, q)
        } else {
            tempB = dp[b]!!
        }
        dp[n] = tempA + tempB
        return dp[n]!!
    }
    print(divc(n, p, q))
}