package kotlin

fun main() {
    var text = readln().toCharArray()
    val n = readln().toInt()
    var arr:Array<String> = Array(n) {""}
    for( i in 0 until n) {
        arr[i]=readln()
    }
    for(i in 0 until 26) {
        for( j in text.indices) {
            if(text[j].code == 122) {
                text[j]='a'
            }
            else{
                text[j]=(text[j].code+1).toChar()
            }
        }
        for( j in arr.indices) {
            if(text.concatToString().contains(arr[j])) {
                print(text)
                return
            }
        }
    }
}