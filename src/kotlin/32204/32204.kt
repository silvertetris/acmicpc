

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }

    var answer = 0L

    for (l in 0 until n) {
        for (r in l until n) {
            var peak = l
            for (i in l + 1..r) {
                if (a[i] > a[peak]) {
                    peak = i
                }
            }

            var isMountain = true

            for (i in l until peak) {
                if (a[i] > a[i + 1]) {
                    isMountain = false
                    break
                }
            }

            if (isMountain) {
                for (i in peak until r) {
                    if (a[i] < a[i + 1]) {
                        isMountain = false
                        break
                    }
                }
            }

            if (isMountain) {
                answer++
            }
        }
    }

    print(answer)
}