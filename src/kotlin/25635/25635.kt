

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextLine()
    val arr = sc.nextLine().split(" ").map { it.toLong() }.toLongArray()
    arr.sort()
    //어차피 왔다리 갔다리만 가능 1찍 2찍 1찍 2찍 느낌으로
    val max = arr[arr.size-1]
    val sum = arr.sum()

    if(max<=sum-max) print(sum) // 그냥 어떠한 경우로 와리가리하면 다 타기 가능
    else print(2*(sum-max)+1) //와리가리 쳐도 맨 큰놈이 남음 -> 작은놈들 이미 다 탔고, 큰놈도 와리가리니까 그만큼 타고, 마지막에 큰놈으로 탐 -> 그니까 +1 해줘야함
}