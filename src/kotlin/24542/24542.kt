fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    /*
    두 사람 간의 친분이 한방향으로만 진행되어야함
    그럼 최초로 어떤 방향으로 정의할지 정하지?
    최종적으로 구해야 하는건 -> 최소 사이클이 개수가 되는 그래프 경우의 수

    -경우
    1. 일단 양방향으로 하고 dp로 경우를 정의함
    2. 처음부터 분리집합으로 합쳐버리기?
    -> 이러면 반대로 튜터 관계를 맺는 경우 최소 인원수가 다를 수 가 있음

    dp가 아님 유니온찾기 문제고
    조합론 문제인거 같음
    1. 일단 사이클에 들어있는 정점수를 각각 도출하고
    2. 각 사이클마다 경우의 수랑 곱하면 될듯함

    1) 사이클 마다의 경우의 수는 정점 수 인듯?
   */

    val rank = IntArray(n + 1) { 1 }
    val parent = IntArray(n + 1) { it }
    val counts = IntArray(n+1) {1}
    fun find(x: Int): Int {
        if (parent[x] != x) parent[x] = find(parent[x])
        return parent[x]
    }
    fun union(a: Int, b: Int) {
        val ra = find(a)
        val rb = find(b)
        if (ra == rb) return
        else if (rank[ra] < rank[rb]) {
            parent[ra] = rb
            counts[rb] +=counts[ra]
            counts[ra] = 1
        } else if (rank[ra] > rank[rb]) {
            parent[rb] = ra
            counts[ra] += counts[rb]
            counts[rb] = 1
        } else {
            parent[rb] = ra
            rank[ra]++
            counts[ra] += counts[rb]
            counts[rb] = 1
        }
    }
    repeat(m) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        union(u, v)
    }
    /*
    count를 일일히 찾으니까 시간초과 -> HashMap으로 바꿈
    HashMap 연산시간이 문제인거 같음. -> 만약 다 끊어져 있는 거라면 20만개라고 쳤을때 HashMap이 더 오래걸림 -> IntArray로 바꿈.
    ->
     */
    var answer = 1L
    for(i in counts) {
        answer = (answer*i) %1_000_000_007
    }
    print(answer)
}