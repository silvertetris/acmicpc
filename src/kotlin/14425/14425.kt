fun main() {
    val br= System.`in`.bufferedReader()
    val(n, m) = br.readLine().split(" ").map { it.toInt() }
    val set = HashSet<String>(n)
    repeat(n) {
        set.add(br.readLine())
    }
    var cnt = 0
    repeat(m) {
        if(set.contains(br.readLine())) cnt++
    }
    print(cnt)
}