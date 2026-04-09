import java.util.*

fun main() {
    val str = StringTokenizer(System.`in`.bufferedReader().readLine())
    val min = str.nextToken().toLong()
    val max = str.nextToken().toLong()
    val temp = max - min + 1
    val isPrime = BooleanArray(temp.toInt()) { true }
    for (i in 2..1000000) {
        //발견되면 여기서 min 뺸 값을 false
        val num = i.toLong()*i
        if (num > max) break
        //i*i는 너무 작음 min부터 시작

        for (j in min/num * num .. max step num) {
            if (j in min..max && (j - min) < temp) {
                isPrime[(j - min).toInt()] = false
            }
        }
    }
    print(isPrime.count { it })
}