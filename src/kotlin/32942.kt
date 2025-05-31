package kotlin

fun main() {
    val(a, b, c) = readln().split(" ").map { it.toInt() }
    var arr:Array<String> = Array<String>(10) {""}
    for(i in 1 .. 10) {
        for(j in 1..10) {
            if(i*a + j*b ==c) {
                arr[i-1] += "$j "
            }
        }
    }
    for(i in arr.indices) {
        if(arr[i]==""){
            println(0)
            continue
        }
        val temp = arr[i].trim().split(" ").map { it.toInt() }.toMutableList()
        temp.sort()
        for(j in temp.indices) {
            print("${temp[j]} ")
        }
        println()

    }
}