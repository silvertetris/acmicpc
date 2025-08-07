fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    val s = br.readLine().toInt()
    var cnt = s
    for (i in 0 until n) {//본래 인덱스 탐색 정렬
        val b = a.sortedDescending()
        if (b == a) break
        for (j in 0 until n) {//idxArr탐색용
            val comp = a.indexOf(b[j])//본 인덱스와 비교하려는 최대 값 (index)
            if (comp - i <= cnt && comp > i && a[comp] > a[i]) {
                cnt -= comp - i
                val temp = a.removeAt(comp)
                a.add(i, temp)
                break
            }
        }
    }
    print(a.joinToString(" "))
}