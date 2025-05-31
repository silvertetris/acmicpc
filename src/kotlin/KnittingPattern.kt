

fun main() {
    val(n, p) = readln().split(" ").map { it.toLong() }
    if(n%2==1L) {
        val middle = n/2 +1
        val startPos = middle - (p/2+1)
        print(2*(startPos%p))
    }
    else {
        val middle = n/2
        val startPos = middle - (p/2)
        val result= startPos%p
        if(result == p/2) {
            print(0)
        }
        else{
            print(result*2)
        }
    }
}