package kotlin

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val r = sc.nextInt()
    val c = sc.nextInt()
    var result = Array(r, { CharArray(c) {'.'} })

    val n = sc.nextInt()
    var sew = ArrayList<Array<String>>(n)
    for (i in 0 until n) {
        val r_i = sc.nextInt()//행 사이즈
        val c_i = sc.nextInt()//열 사이즈
        sc.nextLine()
        val tempArr: Array<String> = Array<String>(r_i) { "" }
        for (j in 0 until r_i) { //행 수 만큼 임시 Array 에 받음
            tempArr[j] = sc.nextLine()
        }
        sew.add(tempArr)
    }
    val m = sc.nextInt()
    for(i in 0 until m) {
        val q = sc.nextInt()
        val t = sc.nextInt()
        val p = sc.nextInt()-1
        for(j in 0 until sew[p].size) {
            for(k in 0 until sew[p][0].length) {
                try {
                    result[q+j][t+k] = sew[p][j][k] //행 x 열
                }catch (e:Exception) {
                    continue
                }
            }
        }
    }
    for(i in result.indices) {
        val charArr:CharArray = result[i]
        println(String(charArr))
    }
}