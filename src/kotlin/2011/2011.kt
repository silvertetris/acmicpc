fun main() {
    val s = readln()
    //크기는 1부터 26 까지


    //#1. states/subProblems
    //dp[i] = 길이가 i 일때 나오는 경우의 수 (인덱스 i+1)
    /*
    2자리가 경우의 수에 포함 할 수 있는 경우 -> -2 자리가 0이나 1이면 다 포함
    -2 자리가 2면 -1 자리는 6까지만 가능
     */
    val dp = IntArray(s.length + 1) { 0 }
    //예외 처리
    if (s.isEmpty() || s.count { it == '0' } == s.length) {
        print(0)
        return
    } else if(s[0] == '0') {
        print(0)
        return
    } else if(s.length == 1) {
        print(1)
        return
    }

    //#2. Base Cases
    dp[0] = 1
    dp[1] = 1


    //#3. transition
    for (i in 2 .. s.length) {
        if(s[i-2]=='0' && s[i-1]=='0'){
            print(0)
            return
        }
        if(s[i-1]!='0') {
            dp[i] = dp[i - 1] % 1_000_000 //그전 자리 수 (근데 0이면 어떡하지?) -> 뭘 어떡해 포함하면 안되지
        }
        val behindSecond = (s[i-2] -'0')*10 + (s[i-1] -'0') //2자리수 까지
        if(behindSecond in 10.. 26) {
            dp[i] +=dp[i-2]%1_000_000
        }
    }

    //#4. final result
    print(dp[s.length]%1_000_000)
}