import kotlin.math.ceil
import kotlin.math.floor

fun main() {
    val br= System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var min = Int.MIN_VALUE
    var max = Int.MAX_VALUE
    for(i in 0 until n) {
        //ax + b<=c
        var(a, b, c) = br.readLine().split(" ").map{it.toDouble()}
        if(a<0) { //ax+b<=c -> x>= (c-b)/a
            c-=b
            c/=a
            min = maxOf(min, ceil(c).toInt())
        } else {
            c-=b
            c/=a
            max = minOf(max, floor(c).toInt())
        }
    }
    val temp = max.toLong()-min.toLong()+1
    if(min==Int.MIN_VALUE || max==Int.MAX_VALUE) {//아니 양쪽에 하나라도 없으면 안되는거지 근데 의미가 있나?
        print(-1)
    }
    else if(temp<=0) {
        print(0)
    }
    else {
        print(temp)
    }
}