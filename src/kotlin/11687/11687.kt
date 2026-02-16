fun main() {

    /*for(m in 5 .. 215 step 5) {
        var result = m.toBigInteger()
        for(i in m-1 downTo 1) {
            result *=i.toBigInteger()
        }
        val temp = result.toString()
        var cnt = 0
        for(i in temp.lastIndex downTo 0) {
            if(temp[i]!='0') break
            else {
                cnt++
            }
        }
        println(cnt)
        println(m)
            println()
        }*/
    val m = readln().toInt()

    /*
    결과값이 5에 제곱에 따라 입력값의 숫자가 1씩 올라감
    만약 결과값이 5의 제곱을 인수로 가지면 2가 뛰고 세제곱을 인수로 가지면 3이 뜀
    그냥 5를 인수로 가지면 1이뜀
    m = sig(n/5^k) k -> 1 .. inf

    최소 N을 찾는게 기준
    m에 대해서 5를 곱한 후에, 역추적해서 n을 카운팅함
    -> 카운팅한게 더 크면 줄이고, 작으면 키우는 이분탐색 법?
    이 함수가 어디에 수렴하는지 모르겠음
    최소 1/5는 가져감으로 m~5m으로 둬야할듯 함
     */
    fun power(base: Int, exp: Int): Int {
        var a = base
        var b = exp
        var result = 1
        while (b > 0) {
            if (b % 2 == 1) result *= a
            a *= a
            b /= 2
        }
        return result
    }

    var l = m
    var r = 5 * m
    while (l <= r) {
        val mid = (l + r) / 2
        var count = 0
        for (i in 12 downTo 1) {
            count += mid / power(5, i)
        }
        if (count < m) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    //그 전껄로하면 3제곱부터 오류 생김 -> 그니까 역추적 방법 위에 식
    var count = 0
    for(i in 12 downTo 1) {
        count += l/power(5, i)
    }
    if(count==m) print(l) else print(-1)
}