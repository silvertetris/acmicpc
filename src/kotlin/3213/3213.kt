

fun minimalPizzas(slices: List<String>): Int {
    var count1_4 = slices.count { it == "1/4" }
    var count1_2 = slices.count { it == "1/2" }
    var count3_4 = slices.count { it == "3/4" }

    var pizzas = 0

    // Pair 3/4 with 1/4
    val pairs = minOf(count3_4, count1_4)
    pizzas += pairs
    count3_4 -= pairs
    count1_4 -= pairs

    // Pair two 1/2 slices
    pizzas += count1_2 / 2
    count1_2 %= 2

    // Handle remaining 3/4 slices
    pizzas += count3_4
    count1_4 -= count3_4 // Each 3/4 uses up a 1/4

    // Handle remaining 1/2 slices
    if (count1_2 > 0) {
        pizzas += 1
        count1_4 -= 2 // A 1/2 slice uses up two 1/4 slices
    }

    // Handle remaining 1/4 slices
    if (count1_4 > 0) {
        pizzas += (count1_4 + 3) / 4 // Group into sets of 4
    }

    return pizzas
}

fun main() {
    // Read input
    val n = readln().toInt()
    val slices = List(n) { readln().trim() }

    // Compute and print the result
    println(minimalPizzas(slices))
}