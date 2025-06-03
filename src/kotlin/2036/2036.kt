import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val a = mutableListOf<Int>()

    for (i in 0 until n) {
        a.add(br.readLine().toInt())
    }
    var answer = 0L
    a.sortWith(compareBy(
        { when {
            it > 0 -> 0  // 양수는 가장 먼저
            it == 0 -> 1 // 0은 중간
            else -> 2    // 음수는 마지막
        } },
        { if (it < 0) - abs(it) else 0 } // 음수일 경우 절댓값 큰 순으로
    ))
    var idx = 1
    var bool = false
    while (idx <= n) {
        if(idx<n) { //하나 도 안남을 경우 뒤에
            if(a[idx-1]==0) {
                bool = true
                idx+=1
                continue
            }
            if (a[idx] > 0 && a[idx - 1] > 0) {
                answer += maxOf(a[idx - 1] + a[idx], a[idx] * a[idx - 1])
                idx+=2
                continue
            }
            if(a[idx-1] <0 ) {
                answer += a[idx-1] * a[idx]
                idx+=2
                continue
            }
            if(a[idx-1]<0 && a[idx]<0) {
                answer += a[idx] * a[idx-1]
                idx+=2
                continue
            }
            if(a[idx-1]>0 && a[idx]<0) {
                answer += a[idx-1]
                idx+=1
                continue
            }
        }
        else {
            if(a[idx-1] >=0) {
                answer += a[idx-1]
            }
            else {
                if(!bool) {
                    answer += a[idx-1]
                }
            }
            break
        }

    }
    print(answer)
}