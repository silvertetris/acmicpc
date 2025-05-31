package kotlin.`2467`

import java.util.*
import kotlin.math.abs

fun main() {
    val sc = Scanner(System.`in`)
    val bw = System.out.bufferedWriter()
    val n = sc.nextLine().toInt()
    val arr = IntArray(n)
    var pair = Pair(0,0)
    var ans = Int.MAX_VALUE
    var negativeIndex = 0
    for (i in 0 until n) {
        arr[i] = sc.nextInt()
        if (arr[i] < 0) {
            negativeIndex = i
        }
    }
    if (arr[0] >= 0 && arr[1] >= 0) {
        bw.write("${arr[0]} ${arr[1]}")
    } else if (arr[n - 2] <= 0 && arr[n - 1] <= 0) {
        bw.write("${arr[n - 2]} ${arr[n - 1]}")
    } else {//이 코드가 투포인터 + 이분탐색
        for (i in 0..negativeIndex) {
            var l = i + 1 //혹시 반대편이 양수가 아니여도 음수끼리 더하는 방안이 가장 0과 가까울 수가 있음
            var r = n - 1
            while(l<=r) {
                val mid = (l + r) / 2
                if(arr[i] + arr[mid] ==0) {
                    bw.write("${arr[i]} ${arr[mid]}")
                    bw.flush()
                    return
                }
                if(abs(arr[i]+arr[mid]) < ans) {
                    ans = abs(arr[i]+arr[mid])
                    pair = Pair(arr[i], arr[mid])
                }
                if(arr[i]+arr[mid] < 0) {
                    l = mid + 1
                }
                else {
                    r = mid - 1
                }
            }
        }
        bw.write("${pair.first} ${pair.second}")
    }
    bw.flush()
    bw.close()
}