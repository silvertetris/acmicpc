fun main() {
    val br = System.`in`.bufferedReader()
    val(n, k, q) = br.readLine().split(" ").map { it.toInt() }
    val nums = IntArray(k)
    val peps = CharArray(k)
    val check = BooleanArray(n) {false}
    check[0] = true
    var cnt = 1
    var qNum = 0
    for(i in 0 until k) {
        val line = br.readLine().split(" ")
        nums[i] = line[0].toInt()
        peps[i] = line[1][0]
        if(i==q-1) {
            qNum = nums[i]
        }
    }
    if(qNum==0) {
        print(-1)
        return
    }
    for(i in k-1 downTo 0) {
        if(nums[i]<qNum) {
            break
        }
        val temp = peps[i].code-65
        if(!check[temp]) {
            check[temp] = true
        }
    }
    for(i in 0 until n) {
        if(!check[i]) {
            print("${(i+65).toChar()} ")
        }
    }
}