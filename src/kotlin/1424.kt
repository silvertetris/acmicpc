package kotlin

fun main() {
    var n = readln().toInt()
    val l = readln().toInt()
    val c = readln().toInt()
    var result = 0
    while (n != 0) {
        var isMax = false
        var cd = c //남은 cd 용량
        var cnt = 0 //노래 카운트
        while (true) {
            cd -= l
            if (cd < 0) {
                isMax = true
                break
            }
            cnt++
            n--
            if (n == 0) { //여기다가?
                if (cd - (l*2) - 1 <= 0) {
                    isMax = true
                }
                break
            }
            cd -= 1
        }
        if (cnt % 13 == 0) { //꽉찬게 있는지, cd가 0보다 작으면
            if (isMax) {
                n++
                result++
                continue
            } else if(result==0){
                n++
                result++
                continue
            }
        }
        result++
    }
    print(result)
}