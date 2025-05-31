package kotlin

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val line = readln().toCharArray()
    var result = 0
    for (i in line.indices) {
        if (line[i] == 'P') {
            var temp=0
            var temp2 =line.size-1
            if(i-k >=0) {
                temp = i-k
            }
            if(i+k <=line.size-1) {
                temp2= i+k
            }
            for (j in temp..temp2) {
                if (line[j] == 'H') {
                    result++
                    line[j] = ' '
                    break
                }
            }
        }
    }
    print(result)

}