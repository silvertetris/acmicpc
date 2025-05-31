

import java.util.*

fun select(a: Array<Int>, p: Int, r: Int, q: Int): Int {
    if(p==r) return a[p]
    val t = partition(a,p,r)
    val k = t-p+1
    if(q>k) return select(a,p,t-1,q)
    else if(q==k) return a[t]
    else return select(a, t+1, r, q-k)
}

fun partition(a: Array<Int>, p: Int, r: Int): Int {
    val x = a[r]
    var i = p - 1
    for (j in p until r) {
        if (a[j] <= x) {
            var temp = 0
            i++
            temp = a[i]
            a[i] = a[j]
            a[j] = temp
        }
    }
    if(i+1!=r){
        var temp=0
        temp=a[i+1]
        a[i+1] = a[r]
        a[r] = temp
    }
    return i+1
}

fun main() {
    val sc = Scanner(System.`in`)
    var n = sc.nextInt()
    var q = sc.nextInt()
    var k = sc.nextInt()
    sc.nextLine()
    var a:Array<Int> = Array(n){0}
    for(i in 0 until n) {
        a[i] = sc.nextInt()
    }
    println(select(a,0, k, q))
    println(a.toList())
}