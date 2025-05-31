package kotlin.`13910`

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    // 입력 받기
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val s = br.readLine().split(" ").map { it.toInt() }

    // DP 배열 초기화 (최소 요리 횟수 저장)
    val INF = 10_000 // 충분히 큰 값
    val dp = IntArray(N + 1) { INF }
    dp[0] = 0

    // 1. 단일 웍 사용 업데이트
    for (wok in s) {
        for (i in wok..N) {
            dp[i] = minOf(dp[i], dp[i - wok] + 1)
        }
    }

    // 2. 두 개의 웍을 동시에 사용하는 경우 업데이트
    for (i in s.indices) {
        for (j in i until s.size) {
            val combined = s[i] + s[j]
            if (combined > N) continue
            for (k in combined..N) {
                dp[k] = minOf(dp[k], dp[k - combined] + 1)
            }
        }
    }

    // 결과 출력
    bw.write(if (dp[N] == INF) "-1" else dp[N].toString())
    bw.flush()
    bw.close()
}
