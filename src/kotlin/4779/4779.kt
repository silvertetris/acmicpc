fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    /*
    목표: div & conq로 자를 인덱스를 찾아야한다
     */
    while (true) {
        val line = br.readLine() ?: break
        val n = line.toInt()
        var size = 1
        repeat(n) {
            size *= 3
        }
        val arr = CharArray(size) { '-' }
        fun divcon(size: Int, start: Int, end: Int) {
            if (size == 1) {
                return
            }
            val temp = size / 3
            for (i in start + temp until end - temp) {
                arr[i] = ' '
            }
            divcon(temp, start, start + temp)
            divcon(temp, end - temp, end)
        }

        divcon(size, 0, size)
        bw.write("${arr.joinToString("")}\n")
        bw.flush()
    }
}