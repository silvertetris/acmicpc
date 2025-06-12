fun main() {
    val br = System.`in`.bufferedReader()
    val s = br.readLine()
    val m = br.readLine().toInt()
    val a = Array(m){""}
    val x = IntArray(m) {0}

    for(i in 0 until m) {
        val temp = br.readLine().split(" ")
        a[i] = temp[0]
        x[i] = temp[1].toInt()
    }

    val dp = IntArray(s.length+2) {0}
    dp[0] = 0
    for(i in 1 .. s.length+1) {
        for(j in 0 until m) {
            if(i-1<a[j].length) {
                dp[i] = maxOf(dp[i-1]+1, i, dp[i])
                continue
            }
            val str = s.substring(i-1-a[j].length, i-1)
            if(str == a[j]) {
                dp[i] = maxOf(dp[i-1]+1, i, dp[i-a[j].length]+ x[j], dp[i])
            } else {
                dp[i] = maxOf(dp[i-1]+1, i, dp[i])
            }
        }
    }
    print(dp[s.length+1]-1)
}

/*
지우고 점수 흭득
삭제 연산
1. 부분 문자열 -> A_i 지우고 X_i 흭득
2. 아무거나 문자 하나 지우고 1점

#1. states / subproblems
dp[i] = i인덱스에서 최대 점수
#2. Base Cases
각 인덱스에 대한 점수 (하나씩 다 지웠을 때)

#3. transitions
dp[i] = maxOf(i, dp[i-a[j].length] + x[j], dp[i])

#4. final answer
dp[s.length]
 */