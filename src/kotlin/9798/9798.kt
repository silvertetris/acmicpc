fun main() {//codeforces 2205D (max-cartesian tree)
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val k = IntArray(n)
    val a = IntArray(n)

    for (i in 0 until n) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        k[i] = u
        a[i] = v
    }
    val inorder = IntArray(n){it}.sortedBy { k[it] }//중위순회 했을때 인덱스 순서
    // min cartesian tree -> 어차피 다 다른데 NO 인 경우가 있을까??
    val parent = IntArray(n) { -1 }
    val left = IntArray(n) { -1 }
    val right = IntArray(n) { -1 }

    val stack = mutableListOf<Int>()//한줄 경로가 될 수 있는 -> 상승구간 인덱스 스택
    for (i in 0 until n) {
        var last = -1
        while(stack.isNotEmpty() && a[stack.last()] > a[inorder[i]]) {//작아지는 태그 타야하는데 만약 a[stack.last()] < a[inorder[i]] 나오면 이거 우측에 넣어야하니까 일단 다 뺴야함
            last = stack.removeLast()
        }
        if(stack.isNotEmpty()) {//값이 더 큰건 중위순회 기준 우측에 넣음
            val top = stack.last()
            parent[inorder[i]] = top
            right[top] = inorder[i]
        }
        if(last!=-1) {
            parent[last] = inorder[i]
            left[inorder[i]] = last
        }
        stack.add(inorder[i])
    }
    bw.write("YES\n")
    for(i in 0 until n) {
        bw.write("${
            if(parent[i]==-1) "0" else parent[i]+1} ${
            if(left[i]==-1) "0" else left[i]+1} ${
            if(right[i]==-1) "0" else right[i]+1}\n")
    }
    bw.flush()
}