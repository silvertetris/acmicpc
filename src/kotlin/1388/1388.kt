

fun main() {
    val (n,m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) {CharArray(m) {' '}}
    for(i in 0 until n) {
        arr[i] = readln().toCharArray()
    }
    var result = 0
    for(i in 0 until n) { //가로 보기
        var isHor = false
        for(j in 0 until m) {
            if(arr[i][j] == '|') {
                isHor = false
                continue
            }
            else if(arr[i][j] =='-' && !isHor) {
                result++
                isHor=true
            }
            else {
                continue
            }
        }
    }
    for( i in 0 until m) {
        var isNor = false
        for(j in 0 until n) {
            if(arr[j][i]=='-') {
                isNor = false
                continue
            }
            else if(arr[j][i]=='|' && !isNor) {
                result++
                isNor = true
            }
            else{
                continue
            }
        }
    }
    print(result)
}