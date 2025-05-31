package kotlin

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val inputText: ArrayList<String> = ArrayList()
    val result: ArrayList<String> = ArrayList()
    val c = sc.nextInt()
    sc.nextLine()

    for (i in 0 until c) {
        inputText.add(sc.nextLine())
    }
    for (i in 0 until c) {
        var letterCount: ArrayList<Int> = ArrayList(26)
        for (j in 0 until 26) {
            letterCount.add(0)
        }
        for (j in 0 until inputText[i].length) {
            if (inputText[i][j] == ' ') {
                continue
            }
            letterCount[inputText[i][j].code - 65]++
        }
        var maxCount: Int = 0
        for (j in letterCount.indices) {
            if (letterCount[j] == letterCount.max()) {
                maxCount++
            }
        }
        if (letterCount.max() == 0) {
            result.add("0 ${inputText[i]}")
            continue
        }
        if (maxCount > 1) {
            result.add("NOT POSSIBLE")
            continue
        }
        var distance = (letterCount.indexOf(letterCount.max()) + 65) - 'E'.code//차이
        if (distance < 0) {
            distance += 26
        }
        val toCharArray: CharArray = inputText[i].toCharArray()
        for (j in toCharArray.indices) {
            if (toCharArray[j] == ' ') continue
            if (toCharArray[j].code - distance < 65) {
                val temp = toCharArray[j].code - distance + 26
                toCharArray[j] = temp.toChar()
                continue
            }
            toCharArray[j] = (toCharArray[j].code - distance).toChar()
        }
        val toString = toCharArray.joinToString("")

        result.add("$distance $toString")
    }
    for (i in 0 until result.size) {
        println(result[i])
    }
}