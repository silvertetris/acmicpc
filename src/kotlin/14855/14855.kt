

fun main() {
    /*
    만두피 안에 만두 속, 만두피 = 밀가루

    만두 종류 = m , 밀가루 양 = n
    만두 종류 = 1..m
    */
    val br = System.`in`.bufferedReader()
    val (n, m, c0, d0) = br.readLine().split(" ").map { it.toInt() }
    val a = IntArray(m + 1) { 0 }
    val b = IntArray(m + 1) { 0 }
    val c = IntArray(m + 1) { 0 }
    val d = IntArray(m + 1) { 0 }
    a[0] = Int.MAX_VALUE
    b[0] = 0
    c[0] = c0
    d[0] = d0
    for (i in 1..m) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        a[i] = temp[0] //제한 만두 속
        b[i] = temp[1] //1개당 요구 만두 속
        c[i] = temp[2] //1개당 요구 만두 피 (밀가루)
        d[i] = temp[3] //value
    }

    /*
    #1. states/ subproblems
    dp[i]= i 밀가루 일때 최대 value
     */

    val dp = IntArray(n + 1) { 0 }

    //#3. transition
    for (i in 0..m) {
        val maxCount = if (b[i] == 0) n / c[i] else a[i] / b[i] //최대 살 수 있는 개수 (한 종류에 대해)

        var k = 1 // 단위 개수

        var count = maxCount
        while (count > 0) {
            val mul = minOf(k, count)
            val cost = mul * d[i]

            for (j in n downTo mul*c[i]) { //해당 인덱스 만두에 대해 knapsack -> 이진분할 나머지 배수 커버됨
                dp[j] = maxOf(dp[j], dp[j - mul*c[i]] + cost)
            }
            count -= mul
            k *= 2 //이진 분할 기법
        }
    }

    //#4. final answer
    println(dp.max())
}
