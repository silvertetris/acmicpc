package kotlin

fun main() {
    val n = readln().toInt()
    val p = readln()
    val q = readln()
    val r = readln()

    // 가능한 모든 숫자 매핑 탐색
    for (h in 1..9) {
        for (j in 1..9) {
            if (j == h) continue
            for (s in 1..9) {
                if (s == h || s == j) continue

                // 현재 매핑
                var pNum = 0L
                var qNum = 0L
                var rNum = 0L

                // p, q, r 문자열을 숫자로 변환
                for (i in 0 until n) {
                    when (p[i]) {
                        'H' -> pNum = pNum * 10 + h
                        'J' -> pNum = pNum * 10 + j
                        'S' -> pNum = pNum * 10 + s
                    }
                    when (q[i]) {
                        'H' -> qNum = qNum * 10 + h
                        'J' -> qNum = qNum * 10 + j
                        'S' -> qNum = qNum * 10 + s
                    }
                    when (r[i]) {
                        'H' -> rNum = rNum * 10 + h
                        'J' -> rNum = rNum * 10 + j
                        'S' -> rNum = rNum * 10 + s
                    }
                }

                // 조건 검증
                if (pNum < qNum && qNum < rNum) {
                    println("HJS! HJS! HJS!")
                    return
                }
            }
        }
    }

    println("Hmm...")
}
