package kotlin.`20958`

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val s = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val isPrime = BooleanArray(10_000_001) {true}
    isPrime[0] = false
    isPrime[1] = false
    val primes = mutableListOf<Int>()
    for(i in 2 .. 10_000_000) { //seive
        if(isPrime[i]) {
            primes.add(i)
            for(j in i*2 .. 10_000_000 step i) { //i*i 못함
                isPrime[j] = false
            }
        }
    }
    //모든 배열이 7이 되기 위한 초기조건
    //1. 7을 인수로 하나만 가져야함 (7이 2개 있으면 7로 한번 나눠야 하기에)
    //2. 그렇다면? 일단 7로 나누고 소수만을 인자로 가지는지 확인하면 되는거 아님?
    var bool = true
    for(i in 0 until n) {
        var temp = s[i]
        if(temp%7!=0) {
            bool = false
            break
        }
        temp/=7
        if(temp%7==0) {
            bool = false
            break
        }
    }
    if(!bool) {
        print("-1")
        return
    }

    val arr = IntArray(n){0} //소수로 만들기 (arr[i]%7 == 0)
    for(i in arr.indices) {
        arr[i] = s[i]/7
    }

    val pre = IntArray(n+m+1) {0} //슬라이딩 윈도우용
    var answer = 0
    //10^7 사이에서 해당값보다
    for (prime in primes) {
        if(prime>3163) break // i*i = 10^7
        if (prime == 7) continue
        var remainOp = 0
        for (i in 0 until n) {
            var count = 0
            while (arr[i] % prime == 0) {
                arr[i] /= prime
                count++
            }
            if (count > remainOp) {
                answer += count-remainOp
                pre[i + m - 1] = count-remainOp //[i, i+m)
                remainOp = count
            }
            remainOp -= pre[i]
        }
        pre.fill(0) //초기화
    }


    val seen = mutableSetOf(1)
    for (i in 0 until n) {
        val num = arr[i]
        if (num !in seen) { //중복아니면 연산 횟수 하나 더 증가함
            seen.add(num)
            pre[i + m - 1] = num
            answer++
        }
        if (pre[i] != 0) {
            seen.remove(pre[i])
        }
    }
    print(answer)
}