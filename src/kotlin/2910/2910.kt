fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,c) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    //long인데 나오는 갯수가 천 이하? -> 해쉬
    val hash = mutableMapOf<Int, Int>()
    for(i in arr.indices) {
        if(!hash.contains(arr[i])) {
            hash[arr[i]] = 1
        } else {
            hash[arr[i]] = hash[arr[i]]!! + 1
        }
    }
    val sorted = hash.toList().sortedByDescending{it.second}
    for(i in sorted.indices) {
        for(j in 0 until sorted[i].second) {
            bw.write("${sorted[i].first} ")
        }
    }
    bw.flush()
}