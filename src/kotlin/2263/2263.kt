fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val inorder = br.readLine().split(" ").map { it.toInt() }.toIntArray()//좌 루트 우
    val postorder = br.readLine().split(" ").map { it.toInt() }.toIntArray()//좌 우 루트

    //중위순회하고, 후위순회가 통일 될 수 있는 경우
    /*
    후위순회는 desc탐색 -> 재귀 우측부터 중위로 맞추기
    탐색해서 기준으로 같은게 있으면 그 거점 기준으로 rec탐
    가둬야지 부모노드 찾았는데 좌우 자식 노드가 어디까지 있나? -> ㅣ, r만 필요한게 아니라 탐색 제한할 범위도 있어야함
     */
    fun rec(l: Int, r: Int, minl: Int, maxr: Int) {
        if (l > r || minl > maxr) return
        bw.write("${postorder[maxr]} ")
        var idx = l//부모 idx
        for (i in l..r) {
            if (inorder[i] == postorder[maxr]) {
                idx = i
                break
            }
        }
        rec(l, idx - 1, minl, minl - 1 + idx - l)//우측 서브 트리 계산 -> 좌노드 rec (어차피 좌측은 끝까지 탐색)
        rec(idx + 1, r, minl + idx - l, maxr - 1)//좌측 서브 트리 크기 계산 -> 우 노드 rec (어차피 우측은 끝까지 탐색)
    }
    rec(0, n - 1, 0, n - 1)
    bw.flush()
    bw.close()
}