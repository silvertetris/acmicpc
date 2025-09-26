fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val h = IntArray(n)
    for(i in 0 until n) {
        h[i] = br.readLine().toInt()
    }
    var temp = h[n-1]
    var cnt = 1
    for( i in n-2 downTo 0) {
        if(temp<h[i]) {
            temp = h[i]
            cnt++
        }
    }
    print(cnt)
}