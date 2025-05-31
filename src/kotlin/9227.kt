package kotlin

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    var word: ArrayList<String> = ArrayList<String>()
    var sentence: ArrayList<String> = ArrayList<String>()

    for (i in 0 until 20) {
        word.add(sc.nextLine())
        if (word[i][0].toInt() == 35 && word[i][1].toInt() == 35) break;
    }

    for (i in 0..100) {
        sentence.add(sc.nextLine())
        if (sentence[i][0].toInt() == 35) break;
    }
    for (i in 0 until sentence.size - 1) { //문장의 배열
        for (j in 0 until sentence[i].length - 3) {//한문장의 길이
            for (k in 0 until word.size - 1) {//단어의 배열
                if (sentence[i][j] == word[k][0]) {
                    if (sentence[i][j + 3] == word[k][1]) {
                        if (((sentence[i][j + 1].code in 65..90) || (sentence[i][j + 1].code in 97..122)) && ((sentence[i][j + 2].code in 65..90) || (sentence[i][j + 2].code in 97..122))) {
                            val toCharArray = sentence[i].toCharArray()
                            toCharArray[j + 1] = '*'
                            toCharArray[j + 2] = '*'
                            sentence[i] = String(toCharArray)
                        }

                    }
                }
            }
        }
    }
    for(i in 0 until sentence.size-1) {
        println(sentence[i])
    }
}