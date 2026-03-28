import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val sets = mutableSetOf<IntArray>()
    repeat(n) {
        val str = StringTokenizer(br.readLine())
        val arr = IntArray(3)
        for (i in 0 until 3) {
            arr[i] = str.nextToken().toInt()
        }
        sets.add(arr.sortedArray())
    }
    /*
    각 숫자 사이에 간선을 연결시킴 -> 서로 다른 배열에 중복되는 수가 있으면 연결하고,
    -> 문제는 순환할 때의 경우의 수가 문제임,
    1. 바로 이어져 있는 간선
    2. 순환할 때 이어질 수 있는 간선

    배열끼리 간선으로 연결

    1 3 4
    1 5 6
    1 3 6
    2 4 5
    2 3 4
    2 5 6

     */
}