

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val dpMin = Array(n) { IntArray(3) { 0 } }
    val dpMax = Array(n) { IntArray(3) { 0 } }
    //base Cases
    val (x, y, z) = br.readLine().split(" ").map { it.toInt() }
    dpMin[0][0] = x
    dpMin[0][1] = y
    dpMin[0][2] = z
    dpMax[0][0] = x
    dpMax[0][1] = y
    dpMax[0][2] = z
    //transitions
    for(i in 1 until n) {
        val(a, b, c) = br.readLine().split(" ").map { it.toInt() }
        dpMin[i][0] = minOf(dpMin[i-1][1], dpMin[i-1][0]) + a
        dpMin[i][1] = minOf(dpMin[i-1][0], dpMin[i-1][1], dpMin[i-1][2]) + b
        dpMin[i][2] = minOf(dpMin[i-1][1], dpMin[i-1][2]) + c
        dpMax[i][0] = maxOf(dpMax[i-1][0], dpMax[i-1][1]) + a
        dpMax[i][1] = maxOf(dpMax[i-1][0], dpMax[i-1][1], dpMax[i-1][2]) + b
        dpMax[i][2] = maxOf(dpMax[i-1][1], dpMax[i-1][2]) + c
    }
    //final answer
    bw.write("${maxOf(dpMax[n-1][0], dpMax[n-1][1], dpMax[n-1][2])} ${minOf(dpMin[n-1][0], dpMin[n-1][1], dpMin[n-1][2])}")
    bw.flush()
    bw.close()
}