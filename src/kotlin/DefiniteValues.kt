package kotlin

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    var result:ArrayList<String> = ArrayList<String>()
    var cnt=0
    while(true) {
        val n = sc.nextInt()
        if(n==0) break
        var str = "a"
        sc.nextLine()
        for(i in 0 until n) {
            val alpha = sc.nextLine().split(" = ")
            val first= alpha.get(0).toCharArray().get(0)
            val second = alpha.get(1).toCharArray().get(0)
            if(str.contains(second)) {
                str+=first
                str+=second
            }
            else if(!str.contains(second)){
                val sb:StringBuilder = StringBuilder(str)
                for(j in sb.length-1  downTo 0) {
                    if(sb[j]==first) {
                        sb.deleteCharAt(j)
                    }
                }
                str=sb.toString()
            }
        }
        result.add(str)
        cnt++
    }
    for(i in 0 until cnt) {
        println("Program #${i+1}")
        if(result.get(i)==""){
            print("none")
        }
        else{
            val charArray = result.get(i).toCharArray()
            charArray.sort()
            var printStr =""
            for(j in charArray.indices) {
                if(printStr.contains(charArray[j])) continue
                printStr += charArray[j]+" "
            }
            print(printStr)
        }

        if(i != cnt-1) {
            println()
            println()
        }

    }
}