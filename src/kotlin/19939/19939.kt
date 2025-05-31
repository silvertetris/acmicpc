

fun main() {
    var (n, k) = readln().split(" ").map{it.toInt()}
    val minCi = if(k%2==0) {
        (k/2)*(k+1)
    } else {
        k/2*(k+1) +(k/2 +1)
    }
    if(minCi>n) {
        print(-1)
    }else {
        n-=minCi
        if(n%k==0) {
            print(k-1)
        }else {
            print(k)
        }
    }
}