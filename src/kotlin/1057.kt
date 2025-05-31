package kotlin

import kotlin.math.abs

fun main() {
    var (n, k, l) = readln().split(" ").map{it.toInt()}
    var result = 1
    while(true) {
        if(abs(l-k) ==1 && l/2!=k/2) break
        if(k%2==0 && k/2!=0) {
            k/=2
        }
        else if(k%2==1) {
            k/=2
            k++
        }
        if(l%2==0 && l/2!=0) {
            l/=2
        }
        else if(l%2==1) {
            l/=2
            l++
        }
        result++
    }
    print(result)
}