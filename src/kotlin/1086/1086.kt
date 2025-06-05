fun main() {
    val br =System.`in`.bufferedReader()
    val bw =System.`out`.bufferedWriter()

    val n = br.readLine().toInt()
    val arr = Array(n) {" "}
    for(i in 0 until n) {
        arr[i] = br.readLine()
    }
    val k = br.readLine().toInt()

}