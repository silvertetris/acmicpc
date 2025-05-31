

import java.util.Stack

fun main() {
    val k = readln().toInt()
    var result= Stack<Long>()
    repeat(k) {
        val input = readln().toInt()
        if(input==0) {
            result.pop()
        }else {
            result.push(input.toLong())
        }
    }
    println(result.sum())
}