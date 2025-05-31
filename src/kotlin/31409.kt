

fun main() {
    val n = readln().toInt()
    var arr:Array<Int>
    arr = readln().split(" ").map{ it.toInt() }.toTypedArray()
    var result = 0

    for(i in arr.indices) {
        if(arr[i]==i+1 && i!=arr.lastIndex) {
            result++
            arr[i]++
        } else if(arr[i]==i+1&&i==arr.lastIndex) {
            result++
            arr[i]--
        }
    }
    println(result)
    for(i in arr.indices) {
        print("${arr[i]}")
        if(i!=arr.lastIndex) {
            print(" ")
        }
    }
}