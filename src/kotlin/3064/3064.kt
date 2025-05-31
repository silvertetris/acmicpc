package kotlin.`3064`

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val result = if(n>4) {
            (n-4)*(n-4)
        } else {
            0
        }
        var arr = Array(n){CharArray(n){' '} }
        for(i in 0 until n) {
            arr[i] = br.readLine().toCharArray()
        }
        if(n==3 && arr[0][0]=='1') {
            bw.write("1\n")
            return@repeat
        }
        if(result ==0) {
            bw.write("$result\n")
            return@repeat
        }
        var answer = 0
        var sum = 0

        for (j in 0 until n) sum += arr[0][j] - '0'
        for (j in 0 until n) sum += arr[j][n - 1] - '0'
        for (j in 0 until n) sum += arr[n - 1][n - 1 - j] - '0'
        for (j in 0 until n) sum += arr[n - 1 - j][0] - '0'

        if (arr[0][0] > '0') answer--
        if (arr[0][n - 1] > '0') answer--
        if (arr[n - 1][n - 1] > '0') answer--
        if (arr[n - 1][0] > '0') answer--

        answer += sum / 3
        answer += (n - 4) * (n - 4)
        bw.write("$answer\n")
    }
    bw.flush()
    bw.close()
}