

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    var result: ArrayList<String> = ArrayList<String>()
    while (true) {

        val inputStr = sc.nextLine()
        if (inputStr == "0") break
        var resultStr = inputStr
        var temp = ""
        if (inputStr.length % 2 == 1) result.add(inputStr)
        else {
            while (true) {

                if (temp.length % 2 != 0) {
                    break
                }
                temp = ""
                for (i in 0 until (resultStr.length / 2)) {
                    repeat(resultStr[2 * i].code - 48) {
                        temp += resultStr[2 * i + 1]
                    }
                }//여기까지 한 단어 완성
                var if_right = 1
                for (i in temp.indices) {
                    if (temp[0] != temp[i]) if_right = 0
                }
                if (if_right == 1 && temp.length % 2 == 1 && temp.length > 2) break
                if (resultStr == temp) break
                resultStr = temp
            }
            result.add(resultStr)
        }

    }
    for (i in 0 until result.size) {
        println("Test ${i + 1}: ${result[i]}")
    }
}