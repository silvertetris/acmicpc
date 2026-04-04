import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val str = StringTokenizer(br.readLine())
    var max = 0
    var ans = 0L
    for(i in 0 until n) {
        val temp = str.nextToken().toInt()
        max = maxOf(temp, max)
        ans+=max
    }
    if(ans%3==0L) {
        print("Delicious!")
    } else{
        print("Oh My God!")
    }
    /*
    맨 위가 뭐야 아 문제 이해하기 힘드네 천천히 다시 읽는다
    아 v에 더했다고 삭제된게 아니구나 좀 멋대로 억측 ㄴㄴ
    최대값 찾고, 탐색 더하기? ->  시간초과
    최대값을 더하는 횟수 -> 지우는 횟수? 이거 아님
    문제 뭔소리인지 모르겠다
    아 위에서부터는 n 부터
    아
     */

}