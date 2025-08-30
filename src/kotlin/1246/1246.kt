import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val p = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val prices = mutableListOf<Int>().apply { addAll(p.asList()) }
    while (prices.size < m) {
        val line = br.readLine() ?: break
        if (line.isNotBlank()) {
            line.split(" ").forEach {
                if (it.isNotBlank()) prices.add(it.toInt())
            }
        }
    }
    val offers = prices.take(m).sortedDescending()

    var bestPrice = 0
    var bestRevenue = 0
    for (i in offers.indices) {
        val price = offers[i]
        val sellCount = min(n, i + 1)
        val revenue = price * sellCount
        if (revenue > bestRevenue || (revenue == bestRevenue && price < bestPrice)) {
            bestRevenue = revenue
            bestPrice = price
        }
    }

    println("$bestPrice $bestRevenue")
}
