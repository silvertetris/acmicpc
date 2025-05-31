

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val mark = IntArray(n)
    fun isAvailable(idx:Int) :Boolean{
        for(i in 0 until idx) {//idx범위 내에서 놀 수 있는 자리가 있나?
            if(mark[idx]==mark[i] || abs(mark[idx] - mark[i])  == abs(idx-i)) {//1. 같은 열 2. 대각
                return false
            }
        }
        return true
    }
    var answer = 0
    fun backTrack(idx:Int) {
        if(idx == n) { //n까지 왔으면 끝
            answer++
            return
        }

        for(i in 0 until n) {
            mark[idx] = i //idx 좌표에 대해 i 칸에 놓았을 때
            if(isAvailable(idx)) { //가능한 자리가 있으면 놓기
                backTrack(idx+1)
            }
        }
    }
    backTrack(0)
    print(answer)
}