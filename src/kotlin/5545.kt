package kotlin

fun main() {
    val n = readln().toInt()
    val (a, b) = readln().split(" ").map{it.toInt()}
    val doughCal = readln().toInt()
    val toppings:MutableList<Int> = mutableListOf()
    repeat(n) {
        toppings.add(readln().toInt())
    }
    toppings.sortDescending()
    var cost = a
    var cal = doughCal
    var result = cal/cost
    for(i in 0 until toppings.size) {
        val temp = (cal+toppings[i])/(cost+b)
        if(result<=temp) {
            cal+=toppings[i]
            cost+=b
            result = cal/cost
        }
        else {
            break
        }
    }
    print(result)
}