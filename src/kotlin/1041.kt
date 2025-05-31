

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toMutableList()
    if (n == 1) {
        arr.sort()
        print(arr.sum() - arr[5])
    } else {
        var answer = 0.toBigInteger()
        val a = minOf(arr[0], arr[5]).toBigInteger()
        val b = minOf(arr[1], arr[4]).toBigInteger()
        val c = minOf(arr[2], arr[3]).toBigInteger()
        val min = arr.min().toBigInteger()
        answer += (n - 2).toBigInteger() * (n - 2).toBigInteger() * min * 5.toBigInteger()
        answer += (n - 2).toBigInteger() * 8.toBigInteger() * minOf(minOf(a + b), minOf(b + c), minOf(a + c))
        answer += (n - 2).toBigInteger() * 4.toBigInteger() * min
        answer += 4.toBigInteger() * minOf(maxOf(a + b), minOf(b + c), minOf(a + c))
        answer += 4.toBigInteger() * (a + b + c)
        print(answer)
    }
}
/*
a, f
b, e
c, d 끼리 마주보고 있음
각 마주보고 있는 애들 제외하고 근접하게 돌리기 가능
1을 제외하고

최대로 노출되는 면 수 -> 3개
서리 쪽
이 모서리는 각 짝에 대해 최대 값을 나오게 해야함
1. 중앙
(n-2) * (n-2) * 제일 큰 눈 * 5
2. 중앙 모서리 (2면 노출), 위쪽
(n-2) * 8 * (각 페어에서 2개 골라서 최대값 더한거)

3. 아래쪽 중앙 모서리 (1면 노출)
(n-2) * 4 *제일 큰 눈

4. 아래 꼭지점 (2면 노출)
4*(각 페어 2개 최대값)
5. 위 꼭지점( 3면 노출)
4* 각 페어 3개 최대값 더한거
 */