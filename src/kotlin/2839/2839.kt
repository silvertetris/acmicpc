package kotlin.`2839`

fun main() {
    var n = readln().toInt()
    if(n == 4 || n == 7) {
        print(-1)
        return
    }
    else {
        var result = n/5
        var remain = n%5
        while(true) {
            if(remain%3==0) {
                result += remain/3
                break
            }
            else {
                result --
                remain +=5

            }
        }
        print(result)
    }
}