fun main() {
    val br = System.`in`.bufferedReader()
    val k = br.readLine().toInt()
    val x = br.readLine().split(" ").map { it.toLong() }.toLongArray().sorted()//k개 종류
    /*
    종류는 k개의 색
박스에는 최대 k개의 공 넣을 수 있음
박스에는 모든 공 색이 같거나 달라야함

박스 개수 최소 값
     */
    val max = x[x.lastIndex]
    var cnt = 0L
    var ans = 0L
    for (i in 0 until k) {
        if (x[i] == max) {
            val rest = k - i //라스트 max개수
            //println(ans)
            //println(rest)
            val temp = rest * ((max - cnt) / k)
            //println(temp)
            ans += temp
            if (((max - cnt) % k).toInt() != 0) {
                if (rest == 1) {
                    ans++
                } else ans += (max - cnt) % k
            }
            break
        } else if (cnt < x[i]) {
            ans += x[i] - cnt
            cnt = x[i]
        }
    }
    print(ans)
}