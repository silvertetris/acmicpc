import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val str = StringTokenizer(br.readLine())
    val arr = IntArray(2*n+1)
    for(i in 0 until 2*n+1) {
        arr[i] = str.nextToken().toInt()
    }
    arr.sort()
    /*
    n개를 뽑았을 때, 그 합이 n의 배수가 되는 경우의 수가 존재하냐?
     */
    
}