package kotlin.`20957`

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    /*
    모든 숫자의 합과 곱이 7의 배수인 수가 몇개인지 구함

N자리 양수중 모든 숫자의 합과 곱이 7의 배수인 수의 개수


구성하는 숫자의 합과 곱이 7의 배수

각 자리마다 더해야하고
각 자리마다 다 곱해야함

1. 각 자리마다 더해서 나오는 수
더해서 7의 배수가 되려면 어떻게 해야할까??
일단 dp[i-1]의 수를 포함하면서
7
70




2. 각 자리마다 곱해서 7의 배수
-> 그냥 자리에 7이 있으면 만족
-> 0 도 7의 배수로 침
그렇다면 구성 요소중에 0이 들어가있다면 모두 만족
     */
}