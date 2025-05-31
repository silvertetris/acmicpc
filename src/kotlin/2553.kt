package kotlin

fun main() {
    val n = readln().toInt()
    var result = 1L
    for(i in 1 .. n) {
        result*=i
        while(result%10 == 0L) {
            result/=10
        }
        result%=1000000
    }
    print(result.toString().last())
}