fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val bw = System.out.bufferedWriter()

    var cnt = 0
    if (n == 2) {
        bw.write("1\n2 1")
        bw.flush()
        return
    }
    if ((n / 2) % 2 == 0) {
        bw.write("$n\n")
    } else {
        bw.write("${n - 1}\n")
    }
    for (i in n - 2 downTo 1 step 2) {
        bw.write("$i ${i + 1}\n")
        cnt++
    }
    if(n%2==0) {
        cnt++
    }
    var temp = 0
    for (i in 0 until cnt/2) {//여기가 문제
        bw.write("1 1\n")
        temp++
    }
    if(n%2==0) {
        temp++
    }
    if (temp % 2 == 0) {
        for (i in 0 until temp/2) {
            bw.write("0 0\n")
        }
    }
    else {
        for(i in 0 until temp/2) {
            bw.write("1 0\n")
        }
    }
    if (temp % 2 == 0) {
        bw.write("0 $n")
    } else {
        bw.write("1 $n")
    }
    bw.flush()
}