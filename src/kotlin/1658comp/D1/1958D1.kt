fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    if(k==0) {
        print(n)
        return
    }

    val arr = LongArray(k+2)
    arr[0] = 1L
}