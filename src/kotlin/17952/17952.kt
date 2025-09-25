fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) {0 to 0} //score to time
    val idx = mutableListOf<Int>()
    var ans = 0
    for(i in 0 until n) {
        val line = br.readLine().split(" ").map { it.toInt() }
        if(line[0] == 1) {
            arr[i] = line[1] to line[2] - 1 // score to time
            idx.add(i)
            if(arr[i].second == 0) {
                ans+=arr[i].first
                idx.removeLast()
            }
        } else {
            if(idx.isEmpty()) continue
            arr[idx.last()] = arr[idx.last()].first to arr[idx.last()].second -1
            if(arr[idx.last()].second == 0)  {
                ans+=arr[idx.last()].first
                idx.removeLast()
            }
        }
    }
    print(ans)
}