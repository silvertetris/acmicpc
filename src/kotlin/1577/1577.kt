

import java.math.BigInteger

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val k = br.readLine().toInt()

    val dp = Array(m + 1) { Array<BigInteger>(n + 1) { BigInteger.ZERO } }

    // 공사중인 도로 정보 저장
    val blockedRight = mutableSetOf<Pair<Int, Int>>() // 오른쪽 방향 막힌 도로
    val blockedDown = mutableSetOf<Pair<Int, Int>>()  // 아래쪽 방향 막힌 도로
    //둘이 한꺼번에 저장하니까 머리가 꺠질거 같은거임 차라리 이렇게 변수를 두개로 나누셈
    for (i in 0 until k) {
        val (a, b, c, d) = br.readLine().split(" ").map { it.toInt() }
        //최종적으로 막히는 방향을 작은 숫자에서 큰 숫자로만 가능함
        if (a == c) {  //가로가 같으면 세로로 가야지
            blockedDown.add(Pair(a, minOf(b, d)))
        } else {       //세로가 같으면 가로롤 가야함
            blockedRight.add(Pair(minOf(a, c), b))
        }
    }

    // 2. baseCases
    dp[0][0] = BigInteger.ONE

    //3. transitions
    for (i in 0..m) {
        for (j in 0..n) {
            if (i == 0 && j == 0) continue
            if (i > 0 && !blockedDown.contains(Pair(j, i-1))) { //아래가 막혀있지 않으면 아래로 가야지 이게 뭔 여기서 왜 헷갈린거임
                dp[i][j] += dp[i - 1][j]
            }
            if (j > 0 && !blockedRight.contains(Pair(j-1, i))) {
                dp[i][j] += dp[i][j - 1]
            }
        }
    }
    //4. final answer
    bw.write("${dp[m][n]}")
    bw.flush()
    bw.close()
}
