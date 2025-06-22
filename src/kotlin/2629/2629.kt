import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val a = br.readLine().toInt() //추 개수
    val load = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val b = br.readLine().toInt() //구슬 개수
    val balls = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    /*
    #1. states / subproblems
    dp[i] = 구슬의 무게가 i 일때, 대조해서 맞출 수 있는지
    추 최대 무게 = 15000
그니까
dp[i] = true면
이미 무게가 i 일때 증명이 가능한거고
dp[i-load[j]에 대해서 이것또한 증명이 가능하다면
dp[i]를 표현 가능하게 만듦
     */
    val dp = BooleanArray(40001) { false }
    //#2. Base Cases
    dp[0] = true
    //#3. transition
    for (j in 0 until a) {
        //덧셈 전파 -> 추를 증명 가능한 구간쪽에 올렸을때
        for (i in 40000 downTo 0) {
            if(dp[i]) {
                if(i+load[j] <= 40000) {
                    dp[i+load[j]] = true
                }
            }
        }
        //뺄셈 전파 -> 추를 반대편에 올렸을 때
        for(i in 0 .. 40000) {
            if(dp[i]) {
                dp[abs(i-load[j])] = true
            }
        }
    }
    //#4. final answer
    for (i in 0 until b) {
        bw.write(if (dp[balls[i]]) "Y " else "N ")
    }
    bw.flush()
    bw.close()
}