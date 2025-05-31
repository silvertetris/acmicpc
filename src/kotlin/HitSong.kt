package kotlin

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val result: ArrayList<String> = ArrayList<String>()
    repeat(n) {
        val p = sc.nextInt()
        sc.nextLine()
        val repetitive: ArrayList<String> = ArrayList<String>()
        for (i in 0 until p) {
            repetitive.add(sc.nextLine().lowercase(Locale.getDefault()))
        }
        val l = sc.nextInt()
        val input: ArrayList<String> = ArrayList<String>()
        var pass = 1
        var temp = 0
        var size = 0
        sc.nextLine()
        for (i in 0 until l) {
            input.add(sc.nextLine())
            val split = input.get(i).split("\\s+|[^a-zA-Z]+".toRegex())
            size += split.size
            if(split.get(split.lastIndex) == "") {
                size--
            }


            for (j in 0 until split.size) {
                for (k in 0 until p) {
                    if (split[j].lowercase(Locale.getDefault())
                            .contains(repetitive[k].lowercase(Locale.getDefault()))
                    ) {
                        temp++
                    }
                }

            }

        }
        if (temp.toDouble() / size.toDouble() < 0.75) {
            pass = 0
        }
        if (pass == 1) {
            result.add("It's a hit!")
        } else {
            result.add("Delete immediately!")
        }
    }
    for (i in result.indices) {
        print(result[i])
        if (i != result.size - 1) {
            println()
        }
    }
}