package kotlin

import java.math.BigInteger
import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()

    // 세그먼트 트리 초기화 (Pair로 구간 합과 최솟값을 함께 관리)
    val tree = Array(4 * n) { Pair(BigInteger.ZERO, Int.MAX_VALUE) }

    fun buildTree(node: Int, left: Int, right: Int) {
        if (left == right) {
            tree[node] = Pair(arr[left].toBigInteger(), arr[left])
        } else {
            val mid = (left + right) / 2
            buildTree(2 * node, left, mid)
            buildTree(2 * node + 1, mid + 1, right)
            val sum = tree[2 * node].first + tree[2 * node + 1].first
            val minVal = min(tree[2 * node].second, tree[2 * node + 1].second)
            tree[node] = Pair(sum, minVal)
        }
    }

    buildTree(1, 0, n - 1)

    fun query(node: Int, left: Int, right: Int, qLeft: Int, qRight: Int): Pair<BigInteger, Int> {
        if (qRight < left || right < qLeft) return Pair(BigInteger.ZERO, Int.MAX_VALUE)
        if (qLeft <= left && right <= qRight) return tree[node]
        val mid = (left + right) / 2
        val leftResult = query(2 * node, left, mid, qLeft, qRight)
        val rightResult = query(2 * node + 1, mid + 1, right, qLeft, qRight)
        return Pair(leftResult.first + rightResult.first, min(leftResult.second, rightResult.second))
    }

    var maxVal = BigInteger.ZERO
    var inx = Pair(0, 0)

    for (i in 0 until n) {
        for (j in i until n) {
            val (sum, minVal) = query(1, 0, n - 1, i, j)
            val score = sum * minVal.toBigInteger()
            if (score > maxVal) {
                maxVal = score
                inx = Pair(i + 1, j + 1)
            }
        }
    }

    println(maxVal)
    println("${inx.first} ${inx.second}")
}