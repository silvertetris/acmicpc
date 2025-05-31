

fun main() {
    val n = readln().toInt()
    val k = readln().toInt()
    var result = 0
    for( i in 1 .. n) {
        var num = i
        for(j in 2 .. k) {
            while(true) {
                if(num%j==0) {
                    num/=j
                }
                else break
            }
        }
        if(num<=k) result++
    }
    print(result)
}