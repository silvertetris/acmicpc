

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    var n = readln().toInt()
    val wr = BufferedWriter(OutputStreamWriter(System.out))
    repeat(n) {
        var (x, y) = readln().split(" ").map { it.toLong() }
        var index =2L
        var max = 1L
        while(index<=x && index<=y) {
            if(x%index==0L && y%index==0L) {
                x/=index
                y/=index
                max*=index
                index=2L
            }
            else{
                index++
            }
        }
        wr.write("${max*x*y}\n")
    }
    wr.flush()
}