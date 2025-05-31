

import kotlin.math.pow

fun main() {
    val n = readln().toInt()
    val output = StringBuilder()
    repeat(n) {
        var arr:ArrayList<Int> = ArrayList<Int>()
        var result = 0
        while(true) {
            val input = readln().toInt()
            if(input==0) break
            else {
                arr.add(input)
            }
        }
        arr.sortDescending()
        for(i in 1 until arr.size+1) {
            result+=arr[i-1].toFloat().pow(i).toInt() * 2
            if(result>5*1000000) {
                output.append("Too expensive\n")
                return@repeat
            }
        }
        output.append("$result\n")
    }
    print(output)
}