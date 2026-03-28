fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val board = Array(9) {IntArray(9)}
    for(i in 0 until 9) {
        val line = br.readLine()
        for (j in 0 until 9) {
            board[i][j] = line[j] - '0'
        }
    }
    
}