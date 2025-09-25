fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }//StayQ size, ans position
    /*
    정렬 안해도됨 -> 그냥 순서대로 큐처리
    덱 문제인가? 라고 치기엔 빠꾸가 없는데 -> 큐로 처리해도 될거 같음
    시간은 1초 -> n*t*p -> 10^5 그냥 하나씩 처리해도 시간초과 안날듯
     */
    val busStop = mutableListOf<Pair<Int, Int>>()
    var prevT = -1
    for (i in 0 until m) {
        val (t, p) = br.readLine().split(" ").map { it.toInt() }
        if(i==0) {
            busStop.add(t to p)
            prevT = t
        }
        else {
            if(prevT == t) {
                busStop.add(t to p)
            } else {
                val timeDiff= t-prevT
                var flag = false
                for(j in 0 until minOf(busStop.size, n)) {
                    busStop[j] = busStop[j].first to busStop[j].second - timeDiff
                    if(busStop[j].second>0) flag = true
                }
                if(!flag) {
                    for(j in 0 until minOf(busStop.size, n)) {
                        busStop.removeFirst()
                    }
                }
                busStop.add(t to p)
                prevT = t
            }
        }
    }
    if(busStop.size>n) {
        while(true) {
            if(busStop.size<=n) break
            val sub = busStop.last().second //얘를 해치워야함
            var flag = false
            for(i in 0 until n) {
                busStop[i] = busStop[i].first to busStop[i].second - sub
                if(busStop[i].second>0) {
                    flag = true
                }
            }
            if(!flag) {
                for(i in 0 until n) {
                    busStop.removeFirst()
                }
            }
        }
    }
    print(busStop.size)
}