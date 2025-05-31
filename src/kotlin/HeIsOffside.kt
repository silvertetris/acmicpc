package kotlin

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    var result = ArrayList<String>()
    while (true) {
        val a = sc.nextInt()
        val d = sc.nextInt()
        var a_d = ArrayList<Int>()
        var d_d = ArrayList<Int>()
        if (a == 0 && d == 0) break
        for (i in 0 until a) a_d.add(sc.nextInt())
        for (i in 0 until d) d_d.add(sc.nextInt())
        a_d.sort()
        d_d.sort()
        //조건문 시작
        for(i in 0 until a_d.size) {
            if (d_d[1] > a_d[i]) {//마지막에서 두번째 보다 공격수가 작을 때 만약 같다면? 어차피 포함 안됨
                if(a_d[i] == d_d[0] && a_d[i] == d_d[1]) {
                    result.add("N")
                    break
                }
                result.add("Y")
                break
            }
            else {
                result.add("N")
                break
            }
        }
    }
    for(i in result.indices) {
        println(result[i])
    }
}