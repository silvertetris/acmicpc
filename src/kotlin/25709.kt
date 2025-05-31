

fun main() {
    var n = readln().toInt()
    var result = 0
    while(n!=0) {
        result++
        var str:StringBuilder = StringBuilder(n.toString())
        if(str.contains('1')&&str.length>1) {
            for(i in str.indices) {
                if(str[i]=='1') {
                    str.deleteCharAt(i)
                    n=str.toString().toInt()
                    break
                }
            }
        }
        else{
            n--
        }
    }
    println(result)
}