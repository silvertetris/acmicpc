fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val isPrime = BooleanArray(n + 1) { true }
    val primes = mutableListOf<Int>()
    isPrime[0] = false
    isPrime[1] = false
    for (i in 2..n) {
        for (j in i * 2..n step i) {
            isPrime[j] = false
        }
    }
    for (i in 0..n) {
        if (isPrime[i]) {
            primes.add(i)
        }
    }
    var l = 0
    var r = 0
    var sum = 0
    var cnt = 0
    while(l<primes.size) {
        if(sum == n) {
            cnt++
            sum-=primes[l++]
        } else if(sum > n) {
            sum-=primes[l++]
        } else {
            if(r<primes.size) {
                sum+=primes[r++]
            } else break
        }
    }
    print(cnt)
}