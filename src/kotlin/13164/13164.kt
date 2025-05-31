

fun main() {
    val br= System.`in`.bufferedReader()
    val(n, k) = br.readLine().split(" ").map { it.toInt() }
    val kids = br.readLine().split(" ").map { it.toInt() }
    val suffixSub = IntArray(n-1)
    for(i in 0 until n-1){
        suffixSub[i] = kids[i+1]-kids[i]
    }
    suffixSub.sort()
    var answer = 0L
    for(i in 0 until n-k) {
        answer+=suffixSub[i]
    }
    print(answer)
}