

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toBigInteger() }.sortedDescending().toMutableList()
    if (arr.size == 1) {
        print(arr[0])
        return
    }
    var total = 0.toBigInteger()
    for( i in 0 until n) {
        total = arr[i]+total+total //첫번째 total = 앞에서 이미 때린거, 두번째 total = 때려서 제일 키큰놈이 증가된거, 거기서 현재 키는 당연히 추가
    }
    print(total%1000000007.toBigInteger())
}