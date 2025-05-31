

import kotlin.math.max

fun findY(charArray: CharArray): MutableSet<Int> {
    val list = mutableSetOf<Int>()
    for (i in charArray.indices) {
        if (charArray[i] == 'Y') {
            list.add(i)
        }
    }
    return list
}


fun main() {
    val n = readln().toInt()
    var arr: Array<CharArray> = Array(n) { charArrayOf() }
    for (i in 0 until n) {
        arr[i] = readln().toCharArray()
    }
    var result = 0
    for (i in arr.indices) {
        var set = mutableSetOf<Int>()
        for (j in arr[i].indices) {
            if (arr[i][j] == 'Y') {
                set.add(j)
                set.addAll(findY(arr[j]))
            }
        }
        set.remove(i)
        result = max(result, set.size)
    }
    print(result)
}