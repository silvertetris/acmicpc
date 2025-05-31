package kotlin.`17074`

import java.util.*

fun main() {
    val sc= Scanner(System.`in`)
    val n = sc.nextLine().toInt()
    val a = MutableList(n+2) {0}
    a[0] = Int.MIN_VALUE
    a[n+1] = Int.MAX_VALUE
    for(i in 1 .. n) {
        a[i] = sc.nextInt()
    }
    if(a.sorted() == a) {
        print(n)
        return
    } else {
        var answer = 0
        var cnt = 0
        var temp1 = 0
        var temp2 = 0
        for(i in 1 .. n) {
            if(a[i]<a[i-1]) {
                cnt++
                temp1 = i-1
                temp2 = i
            }
            if(cnt >=2) {
                break
            }
        }
        if(cnt>=2) {
            print(0)
        }else {
            if(a[temp1-1] <= a[temp2]) answer++ //큰수를 지울 수 있는 경우
            if(a[temp2+1]>=a[temp1]) answer++ // 작은 수를 지울 수 있는 경우
            print(answer)
        }
    }
}