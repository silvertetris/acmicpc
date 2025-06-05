fun main() {
    val br = System.`in`.bufferedReader()
    val(n, k, t ) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    a.sort()
    val preSum = LongArray(a.size) {0L}
    preSum[0] = a[0].toLong()
    for(i in 1 until n) {
        preSum[i] = preSum[i-1]+a[i]
    }
    if(preSum[n-1]%k !=0L) {
        print("NO")
        return
    } else {
        if(t< preSum[(n-1-(preSum[n-1]/k)).toInt()]) {
            print("NO")
        }
        else print("YES")
    }
}