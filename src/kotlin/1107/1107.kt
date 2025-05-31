package kotlin.`1107`

import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val m = br.readLine()
    val ans = abs(100 - n)
    if(m == "0") {
        print(minOf(n.toString().length, ans))
        return
    }
    val broke = br.readLine().split(" ").map { it.toInt() }.sorted()
    var min = 9999999
    var cnt: Int
    for (i in 0..999999) {
        val str = i.toString()
        var check = true
        for (j in str.indices) {
            if (broke.contains(str[j] - '0')) { //부서졌으면 그냥 넘기셈 ㅋㅋ
                check = false
                break
            }
        }
        if (!check) continue

        cnt = str.length + abs(i - n) //완전탐색

        min = minOf(min, cnt)
    }
    print(minOf(min, ans))
}