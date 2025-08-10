fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val initCar = Array(n){""}
    val exitCar = Array(n) {""}
    repeat(n) {
        initCar[it] = br.readLine()
    }
    repeat(n) {
        exitCar[it] = br.readLine()
    }
    var cnt = 0
    for(i in 0 until n) {
        val temp = exitCar.indexOf(initCar[i])//나왔을 때 인덱스
        /*
        만약에 빨리 나온다? 그럼 먼저 0부터 i 까지 있던 차들이, temp부터 n 사이에 존재한다면 cnt++임
         */
        for(j in 0 until i) {
            if(exitCar.indexOf(initCar[j]) in temp until n){
                cnt++
                break
            }
        }
    }
    print(cnt)
}