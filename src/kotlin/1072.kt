package kotlin

fun main() {
    val (x, y) = readln().split(" ").map { it.toLong() }
    val initz = 100 * y / x
    if(initz>=99) {
        print(-1)
        return
    }
    var l = 1L //최소 게임
    var r = 2*x
    var answer = -1L

    var mid: Long
    var newZ: Long
    while (l <= r) {
        mid = (l + r) / 2
        newZ = 100 * (y + mid) / (x + mid)

        if (newZ > initz) {
            answer = mid
            r = mid - 1
        } else {
            l = mid + 1
        }
    }
    print(answer)
}