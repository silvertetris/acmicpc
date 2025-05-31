package kotlin

import java.util.*


fun main() {
    val sc = Scanner(System.`in`)
    val alpha: TreeMap<Char, String> = TreeMap<Char, String>()
    var result: ArrayList<String> = ArrayList<String>()
    for (i in 0 until 26) {
        val temp = sc.nextLine().split(" ")
        alpha[temp[0].toCharArray().get(0)] = temp[1]
    }
    val n: Int = sc.nextInt()
    sc.nextLine()
    val dic: Array<String> = Array(n) { "" } //받은 단어 영어
    val dicMorse: Array<String> = Array(n) { "" }//받은 단어 모스부호
    for (i in 0 until n) {
        dic[i] = sc.nextLine()
        var str: String = ""
        for (j in 0 until dic[i].length) {
            str += alpha[dic[i][j]]
        }
        dicMorse[i] = str
    }//받은 단어들 사전 작업
    while (true) {
        val input = sc.nextInt()
        if (input == 0) break
        sc.nextLine()
        val inputStr: Array<String> = Array(input) { "" }
        var inputTemp: String = ""
        var able: Int = 1
        for (i in 0 until input) {
            inputStr[i] = sc.nextLine()
            val morseIndex = dicMorse.indexOf(inputStr[i])
            if (morseIndex == -1) { // 사전에 없으면
                result.add(String.format("${inputStr[i]} not in dictionary."))
                for (k in 0 until input - i - 1) {
                    sc.nextLine()
                }
                able = 0
                break
            }
            if (i == input - 1) {
                inputTemp += dic[morseIndex]
            } else {
                inputTemp += dic[morseIndex] + " "
            }
        }
        if (able == 1) {
            result.add(inputTemp)
        }
    }
    for (i in result.indices) {
        println(result[i])
    }
}