import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var result = Triple(0, 0, 0)
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray().sorted()
    var sum = Long.MAX_VALUE

    for (i in 0 until n) {
        var l = 0
        var r = n - 1
        while (l+1 < r) {//2칸 차이
            if (l == i) {
                l++
                continue
            }
            if (r == i) {
                r--
                continue
            }
            val temp = arr[l].toLong() + arr[r] + arr[i]
            if (sum > abs(temp)) {
                result = Triple(arr[i], arr[l], arr[r])
                sum = abs(temp)
            }
            if(temp<0) {
                l++
            } else if(temp>0) {
                r--
            } else{
                break
            }
        }
    }
    val res = intArrayOf(result.first, result.second, result.third).sorted()
    print("${res[0]} ${res[1]} ${res[2]}")
}