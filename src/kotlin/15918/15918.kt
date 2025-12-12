import kotlin.math.abs

fun main() {
    val(n, x, y) =readln().split(" ").map{ it.toInt() }
    /*
    2n 만큼 자리에서 x-1 index 하고 y-1index 자리의 숫자가 같아야함
    일단 두 숫자의 차에는 무조건 그 수가 들어가야함
     */
    val diff = abs(x-y)
    val marked = IntArray(2*n)
}