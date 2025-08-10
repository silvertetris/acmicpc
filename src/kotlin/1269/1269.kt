fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map{it.toInt()}
    val a = HashSet<Int>()
    val b = HashSet<Int>()
    a.addAll(br.readLine().split(" ").map{it.toInt()})
    b.addAll(br.readLine().split(" ").map{it.toInt()})
    a.retainAll(b)
    b.retainAll(a)
    val temp = n+m-a.size-b.size
    print(temp)
}