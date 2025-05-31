package kotlin.`16953`

fun main() {
    var (a, b) = readln().split(" ").map { it.toInt() }
    var cnt = 0
    while(a!=b) {
        if(b<a||(b%2==1 && b.toString().last()!='1')) {
            print(-1)
            return
        }
        if(b.toString().last() == '1') {
            b = b.toString().dropLast(1).toInt()
            cnt++
        }
        else {
            b/=2
            cnt++
        }
    }
    print(++cnt)
}