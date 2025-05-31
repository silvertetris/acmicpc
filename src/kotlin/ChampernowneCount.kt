package kotlin

fun main() {
    val (n, k) = readln().split(" ").map { it.toLong() }
    var carry = 0L
    var result = 0

    for (i in 1..n) {
        var num = i // 몇번째인지
        val digits = mutableListOf<Int>() 

        while (num > 0) {
            digits.add((num % 10).toInt()) 
            num /= 10
            println(num)
        }

        for (j in digits.size - 1 downTo 0) {
            carry = (carry * 10 + digits[j]) % k
        }
        if (carry == 0L) {
            result++
        }
    }

    println(result)
}
