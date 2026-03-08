import kotlin.math.pow

fun main() {
    val n = readln().toInt()
    val bw = System.out.bufferedWriter()
    var cnt = 1
    for (i in 1..7) {
        if (2.0.pow(i).toInt() >= n) {
            cnt = i
            break
        }
    }
    val ans = Array(cnt) {CharArray(n)}
    fun dp(start: Int, end: Int, depth: Int) {
        if(start==end||depth>=cnt) {
            return
        }
        val mid = (start+end)/2
        for(i in start until mid) {
            ans[depth][i]='A'
        }
        for(i in mid until end) {
            ans[depth][i]='B'
        }
        dp(start, mid, depth+1)
        dp(mid, end, depth+1)
    }
    dp(0, n, 0)
    for(i in 0 until cnt) {
        bw.write("${ans[i].concatToString()}\n")
    }
    for(i in cnt until 7) {
        bw.write("A".repeat(n-1)+"B\n")
    }
    bw.flush()
}