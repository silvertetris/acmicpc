fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val preorder = mutableListOf<Int>()

    while (true) {
        val line = br.readLine() ?: break
        if (line == "") break
        preorder.add(line.toInt())
    }

    fun rec(l: Int, r: Int) {
        //post로 치면 앞에 나오는애가 무조건 어떤 놈의 부모임
        if (l > r) {
            return
        }
        val parent = preorder[l]
        var idx = r
        var flag = false
        for (i in l + 1..r) {
            if (preorder[i] > parent) {
                // > 패턴 -> stack에 있는 작은것과 결합
                idx = i
                flag = true
                break
            }
        }
        if (flag) {// >패턴 나오면
            rec(l + 1, idx - 1)//좌
            rec(idx, r)//우
        } else {//패턴이 없을 경우 우측에 있는것만 남은거임 -> 우측 탐색만 해야함
            rec(l+1, idx)
        }
        bw.write("${parent}\n")
    }
    /*
    스택오버 플로우 나는 이유...?? -> 아 idx가 고정값이면 rec(idx, r)에서 터짐 (idx가 변하지 않을때) -> l>r로 리턴시켜주고, idx는 무조건 증가해야함
     */
    rec(0, preorder.size - 1)
    bw.flush()
}