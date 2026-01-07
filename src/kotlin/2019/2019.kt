fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    /*
    1. 각 점들을 이음
    2. 이어진 점들이 사이클을 이루는지 확인
    3. 한 정점당 2개의 간선을 가질 수 있으며 이를 초과하면 다각형이 아님
    4. 결국 진짜 깔끔한 사이클만이 다각형
    예를 들어 간선이 3개면 그 3개랑 연결된 모든 사이클은 다각형이 아님
     */
    var cnt = 0
    val arr = HashMap<Pair<Int, Int>, MutableSet<Pair<Int, Int>>>()
    val dup = HashSet<Pair<Int, Int>> ()
    fun dfs(x:Int, y:Int, initx:Int, inity:Int, prevX:Int, prevY:Int) {
        dup.add(x to y)
        if(arr[x to y]!!.size !=2) return
        for(nei in arr[x to y]!!) {
            if(nei == initx to inity &&initx!=prevX && inity!=prevY)  {
                cnt++
                return
            }
            if(dup.contains(nei)) continue//여기서 먼저 걸러져서 최초인지 확인 못함
            dfs(nei.first, nei.second, initx, inity, x, y)
        }
    }
    repeat(n) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
        if(x1 == x2 && y1 == y2) return@repeat
        if(!arr.containsKey(x1 to y1)) {
            arr[x1 to y1] = mutableSetOf(x2 to y2)
        } else {
            arr[x1 to y1]!!.add(x2 to y2)
        }
        if(!arr.containsKey(x2 to y2)) {
            arr[x2 to y2] = mutableSetOf(x1 to y1)
        } else {
            arr[x2 to y2]!!.add(x1 to y1)
        }
    }
    for(i in arr.keys) {
        if(dup.contains(i)) continue
        dfs(i.first, i.second, i.first, i.second, -1, -1)
    }
    print(cnt)
}