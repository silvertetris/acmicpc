package kotlin

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val x = sc.nextInt()
    val y = sc.nextInt()
    val sub = y - x
    var day = 1L
    val result: Long
    while (true) {

        val total: Long = day * day
        if (total == sub.toLong()) {
            result = 2 * day - 1
            break
        } else if (total > sub.toLong()) {
            val lastDay = day - 1
            if (sub - lastDay * lastDay > lastDay) {
                if (((sub - (lastDay * lastDay)) % lastDay).toInt() != 0) {
                    result = 2 * lastDay + ((sub - (lastDay * lastDay)) / lastDay)
                    break
                } else {
                    result = 2 * lastDay - 1 + ((sub - (lastDay * lastDay)) / lastDay)
                    break
                }
            }
            result = 2 * (lastDay)
            break
        } else {
            day++
        }
    }
    print(result)
}