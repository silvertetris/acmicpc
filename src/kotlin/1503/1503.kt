import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map{it.toInt()}

    val line = br.readLine()
    if(line.isBlank()) {
        print(0)
        return
    }
    val arr = line.split(" ").map{it.toInt()}.toIntArray()
    val flag = BooleanArray(1002) {false}
    for(i in 0 until m) {
        flag[arr[i]] = true
    }
    //아 속하지 않는 자연수지 1000까지 수를 써야할 필요는 없는거잖아 아 1*1*1001도 되는거잖아 -> 문제 제대로 읽고 풀기 ㄱㄱ
    /*
    짝수 홀수 -> 고려할때 -> abs값이 0과 가까울 때 결국에 1과 2 차이가 나는데 -> 이를 고려 안함 -> 1001 까지
    1~50 까지 한가지의 수만 풀려있을 때 -> 그 수의 세제곱이 결국 최소값이고, 1만 풀렸을 때는 1001이 최소값임
     */
    var result = Int.MAX_VALUE
    for(i in 1 .. 1001) {
        if(flag[i]) {
            continue
        }
        for(j in i .. 1001) {
            if(flag[j]) {
                continue
            }
            for(k in j .. 1001) {
                if(flag[k]) continue
                result = minOf(result, abs(n-i*j*k))
            }
        }
    }
    print(result)
}