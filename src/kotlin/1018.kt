package kotlin

fun main() {
    val (n, m) = readln().split(" ").map {it.toInt()}
    val arr = Array(n) {readln()}
    var min = 64
    for(i in 0 ..  n-8) { //인덱스가 아닌 사이즈로 뻇으니 .. 이여야함
        for(j in 0 ..  m-8) {
            var startW = 0
            var startB = 0
            for(x in 0 until 8) {
                for(y in 0 until 8) {
                    if((x+y)%2==0) {
                        if(arr[i+x][j+y]=='W') startB++
                        else startW++
                    }else {
                        if(arr[i+x][j+y]=='W') startW++
                        else startB++
                    }
                }
            }
            min = minOf(min, startW, startB)
        }
    }
    print(min)
}