

fun main() {
    val(n, r, c) = readln().split(" ").map{it.toLong()}// 2^(n-1) , row, column
    var answer= 0L
    var cnt = 0L
    fun recurCal(size: Long, rr: Long, cc: Long, r: Long, c: Long) {
        if (rr == r && cc == c) {
            answer = cnt
            return
        }

        if (rr + size > r && rr <= r && cc + size > c && cc <= c) {//
            recurCal(size / 2, rr, cc, r, c)
            recurCal(size / 2, rr, cc + size / 2, r, c)
            recurCal(size / 2, rr + size / 2, cc, r, c)
            recurCal(size / 2, rr + size / 2, cc + size / 2, r, c)
        } else {
            cnt += size * size
        }
    }
    var size = 1L
    for( i in 0 until n) {
        size *=2
    }
    recurCal(size, 0, 0, r, c)
    print(answer)
}