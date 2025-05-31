

fun main() {
    val s = readln()
    val t = readln()
    val str = StringBuilder()
    str.append(t)

    for(i in str.length-1 downTo 0){
        if(str.toString() == s) {
            print(1)
            return
        }else {
            if(str[i] == 'A') {
                str.deleteCharAt(i)
            }
            else {
                str.deleteCharAt(i)
                str.reverse()
            }
        }
    }
    print(0)

}