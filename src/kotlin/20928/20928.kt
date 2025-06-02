fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val p = br.readLine().split(" ").map { it.toInt() }
    val x = br.readLine().split(" ").map { it.toInt() }
    //갈 수 있는 선택지가 많은걸 어떻게 해결하지??
    //최대한 먼거리를 갈 수 있는 지점이 유리??
    var answer = 0
    var idx = 0
    if(n == 1) {
        print(0)
        return
    }
    while(idx<=n) {
        val curnode = p[idx]
        val curdist = x[idx]
        val ableIdx = mutableListOf<Int>()
        for(i in idx until n) {
            if(curnode+curdist>= p[i]) {
                ableIdx.add(i)
            }
        }
        //이제 이것들 중 최대한 으로 갈 수 있는 것 뽑기
        var maxNode = 0
        var nextIdx = -1
        for(i in ableIdx.indices) {
            if(p[i]+x[i]>maxNode) {
                maxNode = p[i]+x[i]
                nextIdx = i
            }
        }

        answer ++
        if(maxNode<m && nextIdx < idx) {
            print(-1)
            return
        } else if(maxNode>=m) {
            print(answer)
            return
        }
        idx = nextIdx
    }
}