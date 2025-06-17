fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt() //days
    val m = br.readLine().toInt()// size
    val a = IntArray(n)
    val b = IntArray(n)
    //회의실 시간 풀었던 그리디 문제 생각남
    for(i in 0 until n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        a[i] = temp[0]
        b[i] = temp[1]
    }

}