

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    //밑면, 높이, 무게
    val below = IntArray(n)
    val height = IntArray(n)
    val weight = IntArray(n)
    repeat(n) {
        val(u,v,w) = br.readLine().split(" ").map { it.toInt() }
        below[it] = u
        height[it] = v
        weight[it] = w
    }

}