package kotlin.`4781`

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    while (true) {
        val (input1, input2) = br.readLine().split(" ")
        if (input1 == "0" && input2 == "0.00") break
        val n = input1.toInt()
        val m = (input2.toFloat() * 100+0.5f).toInt()

        val c = IntArray(n)
        val p = IntArray(n)
        for (i in 0 until n) {
            val (temp1, temp2) = br.readLine().split(" ")
            c[i] = temp1.toInt()
            p[i] = (temp2.toFloat() * 100+0.5f).toInt()
        }
        val dp=IntArray(m + 1) { 0 }
        for(i in 1 .. n) {
            for( j in 1.. m) {
                if(j<p[i-1]) {
                    continue
                }
                else {
                    dp[j] = maxOf(dp[j], dp[j-p[i-1]]+c[i-1]) //unbounded knapsack
                }
            }
        }
        bw.write("${dp[m]}\n")
    }
    bw.flush()
    bw.close()
}