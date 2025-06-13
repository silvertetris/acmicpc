fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val slope = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val udp = IntArray(n + 1) { 1 }
    val ddp = IntArray(n + 1) { 1 }
    //아니 이게 연속적인 값으로 하면 당연히 놓치는 상승구간이 있잖아 그냥 안전하게 N^2로 확인-> 생각 짧게하기 ㄴㄴ
    for (i in 1..n) {
        for (j in 1 until i) {
            if (slope[j - 1] > slope[i - 1]) {
                udp[i] = maxOf(udp[j] + 1, udp[i])
            }
        }
    }

    for (i in n downTo 1) {
        for (j in i + 1..n) {
            if (slope[j - 1] > slope[i - 1]) {
                ddp[i] = maxOf(ddp[j] + 1, ddp[i])
            }
        }
    }

    //#4. final answer
    var answer = 1
    for (i in 1..n) {
        answer = maxOf(answer, udp[i] + ddp[i] - 1)
    }
    answer = maxOf(answer, 1)

    print(answer)
}
