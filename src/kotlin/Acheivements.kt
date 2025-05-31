package kotlin

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val p = sc.nextInt()
    val actualDays = IntArray(n) { sc.nextInt() }

    var maxStreak = 0
    var remainPaid = 0
    var start = 0

    for (end in actualDays.indices) { //actual 사이즈 만큼
        if (end > 0) { //각 일차에 대한 차
            val gap = actualDays[end] - actualDays[end - 1] - 1
            remainPaid += gap
        }


        while (remainPaid > p) { //남은 일수가 지불 일수랑 같아질 때 까지
            val gap = actualDays[start + 1] - actualDays[start] - 1 //별도의 start point를 넣어 남을 일수에서 그 start 포인트에서의 차이를 뺌
            remainPaid -= gap //start point를 옮기기 위해서 맨초기 start point +1 사이의 gap을 빼고 옮김
            start++
        }

        maxStreak = maxOf(maxStreak, actualDays[end] - actualDays[start] + 1 + p - remainPaid)
        //p- remainPaid = 남은 일수를 끝자락에 더해줌
        //actualDays[end]-actualDays[start] 현재 iterating 중인 지점 까지의 차이
    }
    //결국 startpoint와 endpoint를 따로 두는게 맞음
    //pay해야하는 일수가 (remainPaid) p보다 클 경우 startpoint를 옮기는게 관건임
    //endpoint는 한번만 iterating 해도됨. 처음부터 옮길 필요가 없음 (최적화)
    println(maxStreak)
}