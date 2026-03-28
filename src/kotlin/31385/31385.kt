fun main() {
    val n = readln().toInt()
    val bw = System.out.bufferedWriter()
    val limit = n * 100
    val divisors = IntArray(limit + 1) { 2 }
    divisors[0] = 0
    divisors[1] = 1
    //
    for (i in 2..limit) {
        for (j in i * 2..limit step i) {
            divisors[j]++
        }
    }
    /*
    dp로 해야할듯
    udp, ddp로 해서
    아래서 부터 갔을 때 해가 있는지, 위에서 부터 갔을 때 해가 있는지
    dp하면 메모리 터짐
    백트래킹?

     */
    val result = IntArray(n) {0}
    val res = IntArray(n) {0}
    for (i in 1..n) {
        var flag = false
        for(j in 1 .. 300) {

        }
    }
    bw.flush()
}