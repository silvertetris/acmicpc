fun main() {
    val br = System.`in`.bufferedReader()
    val(n, m) = br.readLine().split(" ").map { it.toInt() }
    val a = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val b = Array(n) {br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    if(n<3 || m<3) {
        print(-1)
        return
    }

}