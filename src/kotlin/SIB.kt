

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val arr: Array<Int> = Array(n) { 0 }
    var result = 0L
    for (i in 0 until n) {
        arr[i] = sc.nextInt()
    }
    var sum = arr.sum().toLong()
    //일일히 하지 말고 그 뒤를 다 더한다음에 한번에 곱하기?
    for (i in 0 until n-1) {
        sum -= arr[i]
        result += sum * arr[i]

    }
    print(result)
}