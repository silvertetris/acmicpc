fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val line = br.readLine()
        if(n==1) {
            if(line.length==29) {
                bw.write("2020\n")
            } else if(line.length==28) {
                bw.write("2021\n")
            } else {
                bw.write("Goodbye, ChAOS!\n")
            }
        }
        else {
            val line2 = br.readLine()
            val cnt = line.length * line2.length
            if(cnt == 232) {
                bw.write("2017\n")
            } else if(cnt ==88) {
                bw.write("2018\n")
            } else if( cnt == 754) {
                bw.write("2019\n")
            } else if(cnt == 1015) {
                bw.write("2022\n")
            } else if(cnt==1295) {
                bw.write("2023\n")
            } else if(cnt==1073) {
                bw.write("2024\n")
            }else if(cnt ==348) {
                bw.write("2025\n")
            }
            else {
                bw.write("Goodbye, ChAOS!\n")
            }
        }
    }
    bw.flush()

}