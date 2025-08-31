fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map { it.toInt() }.toIntArray().sorted()
    print(a[k-1])
}