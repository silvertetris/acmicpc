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
        bw.write("${i + 1} $i\n")
        cnt++
    }

    var temp = 0//0나오는 개수
    if (n % 2 == 0) {
        cnt++
    }//1의 개수
    for (i in 0 until cnt - 1 step 2) {//여기가 문제
        bw.write("1 1\n")
        temp++
    }
    for (i in 0 until temp - 1) {
        bw.write("0 0\n")
    }
    if (cnt % 2 == 0) {
        bw.write("0 $n")
    } else {
        if(temp>0) bw.write("1 0\n")
        bw.write("1 $n")
    }
    bw.flush()
}