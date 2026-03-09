fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val f = br.readLine().split(" ").map{it.toInt() }.toIntArray()
    //그니까 p_i까지 왔을때, 최대 증가하는 부분배열 크기가 f_i인거임
    val cnt = IntArray(100_001) {0}
    val startPos = f.toMutableSet().sorted()
    for(i in 0 until n) {
        cnt[f[i]]++
    }
    /*같은 수들은 감소하게 감
    1 2 3 2 4 4 3
    원래는 2가 나와야하는데 2개 수열에 2개나 있으니까 3 시작
    3도 마찬가지 3 2 찼으면 4나와야하는데 2개니까 하나 뛰고 5 시작
    4도 마찬가지, 5 건너띄고 6 지가해야하는데 7부터
    각 수를 먼저 sort하고 거기서 먼저 나오는 수에대해서 뭐부터 시작할지를 정함
    */
    var idx = 0
    for(i in startPos) {
        idx +=cnt[i]
        cnt[i] = idx
    }
    //메모리삑 날 가능성 있음.
    for(i in 0 until n) {
        bw.write("${cnt[f[i]]--} ")
    }
    bw.flush()
    bw.close()
}