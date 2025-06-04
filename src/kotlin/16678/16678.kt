fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val honor = IntArray(n)
    for(i in 0 until n) {
        honor[i] = br.readLine().toInt()
    }

    honor.sort()
    var answer = 0L
    var cnt = 1
    for(i in 0 until n) {
        if(honor[i]<cnt) {
            continue
        } else if(honor[i] == cnt) {
            cnt++
        }
        else {
            answer += honor[i] - cnt
            cnt ++
        }
    }
    print(answer)
}