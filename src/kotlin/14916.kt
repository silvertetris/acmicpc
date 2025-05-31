package kotlin

fun main() {
    var n = readln().toInt()
    var cnt = 0
    if (n == 1 || n == 3) {
        print(-1)
        return
    }
    if (n % 5 == 3 || n % 5 == 1) {
        cnt += n / 5
        n %= 5
        n += 5
        cnt--
        cnt += n / 2
    }
    else {
        cnt+=n/5
        n%=5
        cnt+=n/2
    }


    print(cnt)
}