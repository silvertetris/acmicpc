

fun main() {
    val br = System.`in`.bufferedReader()
    val white = ArrayList<Int>()
    val black = ArrayList<Int>()
    while(true) {
        val temp = br.readLine().split(" ")
        if(temp[0] == "") {
            break
        }
        white.add(temp[0].toInt())
        black.add(temp[1].toInt())
    }

    val dp = Array(white.size+1) {Array(16) {IntArray(16){0} } }


}