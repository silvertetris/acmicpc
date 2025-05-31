package kotlin.`1052`

fun main() {
    var (n, k) = readln().split(" ").map { it.toInt() }
    if (k >= n) {
        print(0)
        return
    } else {
        var answer = 0
        while (true) {
            var cnt = Integer.toBinaryString(n).count { it == '1' }
            if (k >= cnt) break
            n++
            answer++
        }
        print(answer)
    }
}