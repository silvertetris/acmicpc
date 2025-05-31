package kotlin.`30459`

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, r) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map { it.toInt() }.sorted()
    val b = br.readLine().split(" ").map { it.toInt() }.sorted()
    val distance = mutableSetOf<Int>()
    for(i in 0 until n-1) {
        for(j in i+1 until n) {
                distance.add(a[j]-a[i])
        }
    }
    if(0.5 * distance.min() * b[0] >r) {
        print(-1)
        return
    }
    val temp = distance.sorted()
    var answer = 0.0
    for(i in 0 until m) {
        var l = 0
        var right = temp.size-1
        while(l<=right) {
            val mid = (l+right)/2
            if(temp[mid].toDouble() * b[i] * 0.5 > r) {
                right = mid -1
            } else {
                l = mid+1
                answer=maxOf(answer,temp[mid]*b[i]*0.5)
            }
        }
    }
    print("%.1f".format(answer))
}