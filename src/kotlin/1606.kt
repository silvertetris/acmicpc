

import kotlin.math.abs

fun main() {
    var (x, y) = readln().split(" ").map { it.toInt() }
    var result = 1L
    var temp = 0
    if (x <= 0) {
        for (i in 0 downTo x) {
            temp++
            if (i <= -1) {
                result += abs(i) * 6 - 3
            }
        }
        if (y > 0) { //temp -1 까지만 커버 가능

            if (y >= temp) {
                for (i in 0 until temp - 1) {
                    result--
                }
                for (i in temp - 1 until y) {
                    result += i * 6 + 1
                }
            } else {
                for (i in 0 until abs(y)) {
                    result--
                }
            }
        } else if (y < 0) { // y가 음수인 경우
            for (i in 0 downTo y + 1) {
                result += (temp + abs(i)) * 6 - 2
            }
        }
    }
    if (x > 0) {
        for (i in 0..x) {
            temp++
            result += i * 6
        }
        if (y > 0) {
            if (y > 1) {
                for (i in 0 until 1) {
                    result++
                }
                for (i in 2..y) {
                    result += (i+temp-2) * 6 + 1
                }
            } else {
                for (i in 0 until y) {
                    result++
                }
            }
        }
        if (y < 0) {
            if (abs(y) > x) {
                for (i in 0 until temp - 1) {
                    result--
                }
                for (i in temp until abs(y) + 1) {
                    result += (i * 6) - 2
                }
            } else {
                for (i in 0 until abs(y)) {
                    result--
                }
            }
        }
    }
    print(result)
}
