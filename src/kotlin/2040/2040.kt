fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val n = br.readLine().toInt()
    repeat(3){
        val a = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        /*
        #1. states/ subproblems
        dp[i] = i 인덱스일때 각각 고를 수 있는 최소 value
         */
        val aDp = IntArray(n+1) {0}
        val bDp = IntArray(n+1) {0}
        aDp[0] = a[n-1]
        for(i in 0 until n) {

        }
    }
}