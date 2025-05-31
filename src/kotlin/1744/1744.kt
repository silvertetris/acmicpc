

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val plus = mutableListOf<Int>()
    val minus = mutableListOf<Int>()
    var one = 0
    var zero = 0

    repeat(n) {
        val a = br.readLine().toInt()
        when {
            a > 1 -> plus.add(a)
            a == 1 -> one++ // 1은 그냥 더하는 게 이득
            a == 0 -> zero++
            else -> minus.add(a)
        }
    }

    // 큰 수끼리 곱해야 이득(내림차순)
    plus.sortDescending()
    // 작은 음수끼리 곱해야 이득(오름차순)
    minus.sort()

    var answer = 0

    // plus 처리
    var i = 0
    while (i + 1 < plus.size) {
        answer += plus[i] * plus[i + 1]
        i += 2
    }
    if (i < plus.size) answer += plus[i]

    // minus 처리
    i = 0
    while (i + 1 < minus.size) {
        answer += minus[i] * minus[i + 1]
        i += 2
    }
    if (i < minus.size) {
        // 만약 음수가 남았을 때 0이 있으면 곱해서 없애고, 아니면 더함
        if (zero == 0) answer += minus[i]
    }

    // 1은 그냥 더함
    answer += one

    println(answer)
}