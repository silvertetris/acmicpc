package kotlin

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    var result = ArrayList<String>(n)
    sc.nextLine()
    for (i in 0 until n) {
        var temp=""
        val input = sc.nextLine().split(" ")
        for (j in 0 until 5) {
            when (input[j]) {
                ".-" -> {
                    temp += 'A'
                }

                "-..." -> {
                    temp += 'B'
                }

                "-.-." -> {
                    temp += 'C'
                }

                "-.." -> {
                    temp += 'D'
                }

                "." -> {
                    temp += 'E'
                }

                "..-." -> {
                    temp += 'F'
                }

                "--." -> {
                    temp += 'G'
                }

                "...." -> {
                    temp += 'H'
                }

                ".." -> {
                    temp += 'I'
                }

                ".---" -> {
                    temp += 'J'
                }

                "-.-" -> {
                    temp += 'K'
                }

                ".-.." -> {
                    temp += 'L'
                }

                "--" -> {
                    temp += 'M'
                }

                "-." -> {
                    temp += 'N'
                }

                "---" -> {
                    temp += 'O'
                }

                ".--." -> {
                    temp += 'P'
                }

                "--.-" -> {
                    temp += 'Q'
                }

                ".-." -> {
                    temp += 'R'
                }

                "..." -> {
                    temp += 'S'
                }

                "-" -> {
                    temp += 'T'
                }

                "..-" -> {
                    temp += 'U'
                }

                "...-" -> {
                    temp += 'V'
                }

                ".--" -> {
                    temp += 'W'
                }

                "-..-" -> {
                    temp += 'X'
                }

                "-.--" -> {
                    temp += 'Y'
                }

                "--.." -> {
                    temp += 'Z'
                }
            }
        }
        result.add(temp)
    }
    for (i in  1 .. n) {
        println("Case $i: ${result[i-1]}")
    }

}