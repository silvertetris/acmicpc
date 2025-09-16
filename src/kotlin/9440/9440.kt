fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    while (true) {
        val line = br.readLine().split(" ").map { it.toInt() }
        if(line.size==1 && line[0] == 0) break
        val arr = IntArray(line[0])
        for(i in 0 until line[0]) {
            arr[i] = line[i+1]
        }
        arr.sort()
        var one = ""
        var second = ""
        var zero = 0
        for(i in 0 until arr.size) {
            if(arr[i] == 0) {
                zero++
            }
            else {

            }
        }
    }
}