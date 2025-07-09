fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    val isPrime = BooleanArray(2001) {true}
    isPrime[0] = false
    isPrime[1] = false
    for(i in 2 .. 2000) {
        for(j in i*i .. 2000 step i) {
            isPrime[j] = false
        }
    }
    val primeCnt = IntArray(2001) {0}
    for(i in 1 .. 2000) {
        primeCnt[i] = primeCnt[i-1] + if(isPrime[i]) 1 else 0
    }

    repeat(t) {
        val ( a, b) = br.readLine().split(" ").map { it.toInt() }
        /*
        #1. states/ subproblems
        dp[i] = i번 울렸을 때, 가질 수 있는 점수 차
         */
        val dp = IntArray(b+1) {Int.MIN_VALUE}
        //#2. Base Cases
        dp[b] = 0 //b번 울렸을때 더는 점수를 얻을 수 없음
        //#3. transition
        for(i in b-1 downTo 0) {
            var best = Int.MIN_VALUE
            for(j in 0.. a) { //다음턴 최대 깊이 a
                if(i+j>b) break
                best = maxOf(best, primeCnt[i+j] - primeCnt[i] - dp[i+j])//i부터 그 후 다음턴 까지 얻을 수 있는 점수 - 그 전 점수차
            }
            dp[i] = best //상대 입장에서 가장 크게 먹을 수 있는 점수차
            //이게 서로 전파되면서, 영역, 그전 점수차를 빼주면서 최선의 선택을 하게됨 O(b*a)
        }
        var result: String
        if(dp[0]>0) result = "kuro"
        else if(dp[0]<0) result = "siro"
        else result = "draw"
        bw.write("$result\n")
    }
    bw.flush()
    bw.close()
    br.close()
}