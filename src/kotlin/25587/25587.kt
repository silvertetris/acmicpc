fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val b = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val parent = IntArray(n + 1) { it }
    val rank = IntArray(n + 1) { 0 }
    val aRoot = IntArray(n + 1)
    val bRoot = IntArray(n + 1)
    for (i in 1..n) {
        aRoot[i] = a[i - 1]
        bRoot[i] = b[i - 1]
    }
    val childCnt = IntArray(n + 1) { 1 }

    fun find(x: Int): Int {
        if (parent[x] != x) parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(x: Int, y: Int): Int {
        val ra = find(x)
        val rb = find(y)
        if (ra == rb) return 0

        var temp = 0
        if (bRoot[ra] > aRoot[ra]) temp -= childCnt[ra]//일단 중복 빼
        if (bRoot[rb] > aRoot[rb]) temp -= childCnt[rb]
        val newRoot = if (rank[ra] < rank[rb]) {
            parent[ra] = rb
            //일단 양 루트 a, b수치는 합쳐줘야함 -> 홍수가 날지 안날지 모르니
            aRoot[rb] += aRoot[ra]
            bRoot[rb] += bRoot[ra]
            childCnt[rb] += childCnt[ra]
            rb
        } else if (rank[ra] > rank[rb]) {
            parent[rb] = ra
            aRoot[ra] += aRoot[rb]
            bRoot[ra] += bRoot[rb]
            childCnt[ra] += childCnt[rb]
            ra
        } else {
            parent[rb] = ra
            rank[ra]++
            aRoot[ra] += aRoot[rb]
            bRoot[ra] += bRoot[rb]
            childCnt[ra] += childCnt[rb]
            ra
        }
        if (bRoot[newRoot] > aRoot[newRoot]) temp += childCnt[newRoot] //다 홍수니까 싸그리 더함
        return temp// 안난거니까 뺴줘야함 -> 홍수난게 살려짐
    }

    var ans = 0
    //Base Cases
    for (i in 1..n) {
        if (bRoot[i] > aRoot[i]) {
            ans += 1
        }
    }

    repeat(m) {
        val line = br.readLine().split(" ").map { it.toInt() }
        if (line[0] == 1) {
            ans += union(line[1], line[2])
        } else {
            bw.write("$ans\n")
        }
    }
    bw.flush()
    bw.close()
}
