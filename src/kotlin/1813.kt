

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    var arr:Array<Int> =Array(51) {0}

    repeat(n) {
        var input = sc.nextInt()
        arr[input]++
    }
    var temp = 0
    for(i in arr.size-1 downTo 1) {
        if(arr[i]==i) {
            print(arr[i])
            temp=1
            break
        }
    }
    if(temp==0&&arr[0]>0) {
        print(-1)
    }
    else if(temp==0) {
        print(0)
    }
}