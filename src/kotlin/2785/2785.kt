package kotlin.`2785`

fun main() {
    val n = readln().toInt()
    val lengths = readln().split(" ").map { it.toInt() }.toMutableList()
    lengths.sort()
    var cnt = 0
    while(lengths.size>1) {
        lengths[0] = lengths[0]-1
        lengths.removeLast()
        if(lengths[0] == 0) lengths.removeFirst()
        cnt++
    }
    print(cnt)
}