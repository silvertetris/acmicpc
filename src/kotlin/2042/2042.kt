

import java.math.BigInteger

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { 0.toBigInteger() }
    val tree :Array<BigInteger> = Array(4*n) { BigInteger.ZERO }
    for (i in 0 until n) {
        arr[i] = br.readLine().toBigInteger()
    }


    fun treeInit(node: Int, left: Int, right: Int) { //구간합 트리 초기화
        if (left == right) { //트리의 리프노드에 모든 arr을 담을 거임
            tree[node] = arr[left]
        } else {
            val mid = (left + right) / 2 //각 노드의 중간 인덱스 값
            treeInit(2 * node, left, mid)//좌측 노드
            treeInit(2 * node + 1, mid + 1, right) //우측 노드
            tree[node] = tree[2 * node] + tree[2 * node + 1] // 두 자식 노드의 합 = 상위 노드
        }
    }
    treeInit(1, 0, n - 1)

    fun update(node: Int, left: Int, right: Int, newInx: Int, newVal: BigInteger) {
        if (left == right) {//만약 자식 노드면 그냥 새로운값 대입하면 됨 (tree의 delete 함수 생각하면 될듯)
            tree[node] = newVal
        } else { //하지만 아닐 시에는 위에거 까지 다 바꿔야함
            val mid = (left + right) / 2
            if (newInx in left..mid) {//좌측일 경우
                update(node * 2, left, mid, newInx, newVal)
            } else {
                update(node * 2 + 1, mid + 1, right, newInx, newVal)
            }
            tree[node] = tree[2 * node] + tree[2 * node + 1]
        }
    }

    fun sum(node: Int, left: Int, right: Int, b: Int, c: Int): BigInteger {

        if (c < left || right < b) { //말이 안되는 조건
            return 0.toBigInteger()
        } else if (b <= left && right <= c) {//부모 노드의 좌, 우가 b부터 c인 구간과 일치할 때
            return tree[node]
        } else { //아니면 상위 탐색
            val mid = (left + right) / 2
            return sum(node * 2, left, mid, b, c) + sum(node * 2 + 1, mid + 1, right, b, c)
        }
    }
    for (i in 0 until m + k) {
        val input = br.readLine().split(" ")
        val a = input[0].toInt()
        val b = input[1].toInt()
        val c = input[2].toBigInteger()
        if (a == 1) {
            update(1, 0, n - 1, b - 1, c)
        } else {
            bw.write("${sum(1, 0, n - 1, b - 1, (c - 1.toBigInteger()).toInt())}\n") //인덱스는 0부터 시작 (생각해야함)
        }
    }
    bw.flush()
    bw.close()
}