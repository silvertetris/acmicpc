

import java.math.BigInteger

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toBigInteger()
        var l = BigInteger.ONE
        var r = n
        while (l<=r) {
            val mid = (l+r) / 2.toBigInteger()
            if(mid*(mid+1.toBigInteger())/2.toBigInteger() <=n) {
                l = mid+1.toBigInteger()
            } else {
                r = mid-1.toBigInteger()
            }
        }
        bw.write("${l-BigInteger.ONE}\n")
    }
    bw.flush()
    bw.close()
}