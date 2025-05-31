

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val input = br.readLine().split(" ").map { it.toLong()}.sortedDescending()

    val sum = input.sum()
    val avgProperty: Double = sum.toDouble() / n
    var bigSum = 0.0
    var bigNum = 0
    for (i in 0 until n) {
        if (input[i] > avgProperty) {
            bigSum += input[i]
        } else {
            bigNum = i
            break
        }
    }
    val y = (bigSum / sum)
    val x: Double = (bigNum.toDouble() / n)
    val differ = (y - x) * 100
    print(differ)
}