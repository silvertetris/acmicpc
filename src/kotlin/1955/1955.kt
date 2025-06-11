import kotlin.math.sqrt

fun main() {
    val n = readln().toInt()
    val dp = IntArray(n+1) {0}
    /*
    #1. states/ subproblems
    -> 결국 합은 남는 수랑 비교고
경우의 수 조합이 총 3개임
1. 곱하기만 하거나
2. 팩토리얼만 하거나
3. 곱하기와 팩토리얼을 섞거나

그리고 결국에 더하기만 하는건 계산할 필요가 없음
-> 1은 베이스 케이스고, 2도 결국 1+1해놓고 팩토리얼 하면됨, 3도 2*1 팩토리얼 해놓고 1 더하면 되고
더하기는 그저 디폴트로 해당 값까지 적게 만든 수에 + count 하는 식으로 한다

dp[i][j] = i수일 때 j 연산 방법 채택 후 최소 1의 개수
지만 어차피 3번으로 합칠꺼 1차원 배열로 해도 될거같음 복잡하게 말고
dp[i] = i값일 때 최소 1 개수
수가 커지면 커질수록 팩토리얼로 먼저 조지는게 효율적임 -> 근데 이걸 어떻게 부분? -> 6부터만해도 팩토리얼이 들어가는게 무조건 이득임

줄여나가기 -> 팩토리얼 -> 팩토리얼 덧셈 or 팩토리얼 곱셈 덧셈
결국 두 분야에 대한 덧셈이 필요함

     */
    val factorial = IntArray(8) {0} //5040
    factorial[1] = 1
    for(i in 2.. 7) {
        factorial[i] = i*factorial[i-1]
    }
    //#2. Base Cases
    dp[1] = 1

    //#3. transitions
    for(i in 2 .. n) {
        dp[i] = i
        for(j in 1.. 7) {
            if(factorial[j]>i) break
            else if(factorial[j] == i) {
                dp[i] = j
                break
            }
        }
        for(j in  1.. i/2) {
            dp[i] = minOf(dp[i], dp[i-j]+dp[j])
        }
        val lim = sqrt(i.toDouble()).toInt()
        for(j in 2.. lim) {
            if(i%j==0) {
                dp[i] = minOf(dp[i], dp[i/j]+dp[j])
            }
        }
    }
    print(dp[n])
}