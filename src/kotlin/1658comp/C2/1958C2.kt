fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    /*
    이거 10차원 배열 만드는건 아닌거 같은데
    0 1 패턴이 유지되어야 하는건가?
    각 변수에서 1을 뺀만큼 유지
     */
    val line = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var sum = 1
    for (i in 0 until 10) {
        sum *= line[i]
    }
    var flag = true
    for (i in 0 until  sum step line[9]) {
        var temp = IntArray(line[10]) {-1}
        for(j in 0 until line[9]) {
            val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
            for(k in 0 until arr.size) {
                if(temp[k] == arr[k]) flag = false
            }
            temp = arr
        }
    }


    if (flag) {
        bw.write("Yes\n")
    } else {
        bw.write("No\n")
    }
    bw.flush()
}