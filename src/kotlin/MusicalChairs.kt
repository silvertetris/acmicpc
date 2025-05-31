package kotlin

import java.util.Scanner

//17857
fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    var composeList: ArrayList<Array<Int>> = ArrayList<Array<Int>>() //0 자리 = 교수 순번, 1자리 = 최애곡 모음
    for (i in 0 until n) {
        composeList.add(arrayOf(i, sc.nextInt()))
    }
    var startIndex = 0
    while (composeList.size != 1) {
        var shouldIterate = (composeList.get(startIndex).get(1) - 1) % composeList.size
        var deleteIndex: Int
        if(startIndex+shouldIterate>composeList.size-1) {
            deleteIndex=startIndex+shouldIterate-composeList.size
        } else{
            deleteIndex=startIndex+shouldIterate
        }
        composeList.removeAt(deleteIndex)
        if(deleteIndex>composeList.size-1){
            startIndex = 0
        } else{
            startIndex = deleteIndex
        }
    }
    println(composeList.get(0).get(0)+1)
}