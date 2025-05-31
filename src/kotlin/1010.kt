package kotlin

fun main() {
    val t = readln().toInt()
    val bw = System.out.bufferedWriter()
    repeat(t) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        var fn = 1.toBigInteger()
        var fm = 1.toBigInteger()
        for(i in 0 until n) {
            fm*=m.toBigInteger()-i.toBigInteger()
            fn*=n.toBigInteger()-i.toBigInteger()
        }
        bw.write("${fm/fn}\n")
    }

    bw.flush()
    bw.close()
}