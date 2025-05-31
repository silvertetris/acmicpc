

import kotlin.math.abs
import kotlin.math.max

fun main() {
    val n = readln().toInt()
    var arr:Array<Int> = readln().split(" ").map{it.toInt() }.toTypedArray()
    for(i in 2 until arr.size step 2) {
        if(abs(arr[i-2]-arr[i])==2) {
            arr[i-1] = (arr[i-2]+arr[i])/2
        } else if(arr[i-2] ==arr[i]) {
            arr[i-1] = arr[i-2]+1
        }
    }
    var result = 0
    var temp = 0
    var i=0
    while(i!=n) {
        temp++
        if(i==arr.lastIndex) {
            result=max(result, temp)
            break
        }
        if(arr[i]==0) {
            result = max(result, temp)
            temp =0
            arr[i]=1
            continue
        }
        i++
    }
    print(result)
}