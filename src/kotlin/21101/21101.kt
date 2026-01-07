fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val a = IntArray(n)
    val b = IntArray(n)
    /*
    #1. state / subproblems
    dp[i][j] = i index 까지 행복한 날의 개수가 j개인 최소합
     */
    for(i in 0 until n) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        a[i] = u
        b[i] = v
    }
    val dp =Array(n+1) {IntArray(n+1) {Int.MAX_VALUE-1_000_000} }
    //#2. Base Cases
    dp[1][1] = minOf(a[0], b[0])
    //#3. transitions
    for(i in 2..n) {
        //그 전날 까지의 평균을 기준으로 해야함 그니까 i-2까지만 보면 됨
        for(j in 0 until i) {
            if(dp[i-1][j]>=Int.MAX_VALUE-1_000_000) continue
            //j에서 추가하는건 i에 따라 달라짐
            val choiceA = if(dp[i-1][j]<=(i-1)*a[i-1]) 0 else 1
            /*
            봐봐 슬픔을 추가하고, 아니면 추가를 안하니까 계속홰서 이 j index를 유지할 수 있음
            아니면 하나씩 추가하는거고 그니까 temp는 동적일 수 밖에 없음
             */
            //이걸 선택했을 때, 차라리 슬픈게 더 적냐 아니면 골랐을때 그 평균이 더 작냐 -> 결국 최소합을 뽑아냄
            dp[i][j+choiceA] = minOf(dp[i][j+choiceA], dp[i-1][j]+a[i-1])
            val choiceB = if(dp[i-1][j] <= (i-1) * b[i-1]) 0 else 1
            dp[i][j+choiceB] = minOf(dp[i][j+choiceB], dp[i-1][j]+b[i-1])
        }
    }

    //#4. final answer
    for(i in 0..n) {
        if(dp[n][i]<Int.MAX_VALUE-1_000_000) {
            print(i-1)
            return
        }
    }
}