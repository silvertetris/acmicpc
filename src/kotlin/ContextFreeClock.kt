package kotlin

import java.util.*
import kotlin.math.floor

fun main() {
    val sc = Scanner(System.`in`)
    var result = ArrayList<String>()
    while (true) {
        var input = sc.nextLine()
        if (input.equals("-1 00:00:00")) break
        var a = input.split(" ").get(0).toFloat()
        var hour = input.split(" ").get(1).split(":").get(0).toFloat()
        var minute = input.split(" ").get(1).split(":").get(1).toFloat()
        var second = input.split(" ").get(1).split(":").get(2).toFloat()
        var hourAngle = (hour * 30) % 360
        var minuteAngle = (minute * 6) % 360
        minuteAngle += (second / 10)
        hourAngle += (minuteAngle / 12)
        val currentAngle = (minuteAngle - hourAngle + 360) % 360 //시침에서부터 분침까지의 각도 (절대값)
        var addingSec: Int
        var needAngle = (a - currentAngle + 360) % 360
        //if (minuteAngle - hourAngle <= 0) {
            addingSec = floor(needAngle / 11 * 120).toInt()
        /*} else {
            addingSec = ceil(needAngle / 11 * 120).toInt()
        }*/

        var addingMin: Int = minute.toInt() + ((addingSec + second) / 60).toInt()
        var addingHour: Int = (hour.toInt() + (addingMin / 60)) % 24
        addingMin %= 60
        addingSec %= 60
        var finalSec: String = addingSec.toString()
        var finalMin: String = addingMin.toString()
        var finalHour: String = addingHour.toString()
        if (addingSec.toString().length == 1) finalSec = "0$addingSec"
        if (addingMin.toString().length == 1) finalMin = "0$addingMin"
        if (addingHour.toString().length == 1) finalHour = "0$addingHour"
        result.add("${finalHour}:${finalMin}:${finalSec}")
    }
    for (i in result) {
        println(i)
    }
}