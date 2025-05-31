

import java.util.*

typealias ll = Long

data class Cell(val length: Int, val stackedLength: ll, val index: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var s: ll = 0
    var temp: ll
    var v: ll
    var startIdx = 1
    var endIdx = 1
    var stemp = 0
    var etemp: Int
    val st = Stack<Cell>()
    val arr = br.readLine().split(" ").map { it.toLong() }
    for (i in 0 until n) {
        v = arr[i]
        temp = 0
        while (st.isNotEmpty() && v < st.peek().length) {
            temp += st.peek().stackedLength
            stemp = st.peek().index
            if (temp * st.peek().length > s) {
                startIdx = stemp
                endIdx = i
                s = temp * st.peek().length
            }
            st.pop()
        }
        temp += v
        st.push(Cell(v.toInt(), temp, if (temp > v) stemp else i + 1))
    }

    temp = 0
    etemp = st.peek().index
    while (st.isNotEmpty()) {
        temp += st.peek().stackedLength
        if (temp * st.peek().length > s) {
            startIdx = st.peek().index
            endIdx = etemp
            s = temp * st.peek().length
        }
        st.pop()
    }

    println(s)
    print("$startIdx $endIdx")
}
