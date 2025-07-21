fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val(n, m) = br.readLine().split(" ").map { it.toInt() }
    repeat(m) {
        val s = br.readLine().split(" ").map{ it.toInt() }.toIntArray().sortedDescending()
        val revers = s.sorted()
        val minusTwo = s.count{it == -2}
        val minusOne = s.count{it == -1}
        val one = s.count{it == 1}
        val two = s.count{it == 2}
        val zero = s.count{it == 0}
        if(one + two == 0 && minusTwo + minusOne<=1&&zero!=0) {
            bw.write("0\n")
        }
        else if(n==1) {
            bw.write("${s[0]}\n")
        }
        else {
            var result = 1L
            for(i in 0 until n) {
                if(s[i]<=0) {break}
                result*=s[i]
            }
            var idx = 0
            for(i in 0 until n) {
                if(revers[i]>=0) {break}
                result*=revers[i]
                idx = i
            }
            if(result<0) {
                result /= revers[idx]
            }
            bw.write("${result}\n")

        }
    }
    bw.flush()
    bw.close()
}