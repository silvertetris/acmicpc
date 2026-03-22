import java.util.StringTokenizer

fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val str = StringTokenizer(br.readLine())
    val check = BooleanArray(1_000_001) {false}
    val x= IntArray(n)
    for(i in 0 until n) {
        x[i] = str.nextToken().toInt()
        check[x[i]] = true
    }
    val arr= x.sorted()
    val max = arr[n-1]
    val scores = IntArray(1_000_001) {0}
    for(i in 0 until n) {
        for(j in arr[i] .. max step arr[i]) {
            if(check[j]) {
                scores[arr[i]]++
                scores[j]--
            }
        }
    }
    for(i in 0 until n) {
        bw.write("${scores[x[i]]} ")
    }
    bw.flush()
    /*
    그니까 어떤 수에 대해서 정렬을 시켜놓고, 그 뒤에 배수들을 확인한다?
     */
}