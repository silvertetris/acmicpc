

fun main() {
    val n = readln().toLong()
    var answer = -1L
    var fiveBag = n / 5

    while (fiveBag >= 0) {
        val rest = n - fiveBag * 5
        if (rest % 3 == 0L) {
            answer = fiveBag + (rest / 3)
            break
        }
        fiveBag--
    }
    println(answer)
}