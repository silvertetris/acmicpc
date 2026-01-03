import kotlin.math.abs
import kotlin.math.pow

fun main() {
    val input = readln().split(" ").map { it.toDouble() }
    val xa = input[0]
    val ya = input[1]
    val xb = input[2]
    val yb = input[3]
    val xc = input[4]
    val yc = input[5]
    //조건은 1직선에 있을때 안됨
    if (((xa - xb) / (ya - yb) == (xb - xc) / (yb - yc) && (xa - xc) / (ya - yc) == (xa - xb) / (ya - yb)) ||
        (xa to ya == xb to yb) || (xb to yb == xc to yc) || (xa to ya == xc to yc) ||
        ((ya-yb)==0.0 &&(yb-yc)==0.0) || ((yb-yc==0.0) && (ya-yc)==0.0)) {
        print(-1.0)
        return
    }
    //길이
    val atob = (xa - xb).pow(2) + (ya - yb).pow(2)
    val btoc = (xb - xc).pow(2) + (yb - yc).pow(2)
    val atoc = (xc - xa).pow(2) + (yc - ya).pow(2)
    /*
    atob 와 atoc
    atob 와 btoc
     */
    print(
        maxOf(
            abs(atoc.pow(0.5) - btoc.pow(0.5)),
            abs(btoc.pow(0.5) - atob.pow(0.5)),
            abs(atob.pow(0.5) - atoc.pow(0.5))
        ) * 2
    )
}