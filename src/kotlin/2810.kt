

fun main() {
    val n = readln().toInt()
    val word = readln()
    if(!word.contains('L')) {
        print(n)
        return
    }
    var result = 0
    var i = 0
    while(i!=n) {
        if(word[i] == 'L') {
            i+=2
            result++
        }
        else {
            i++
            result++
        }
    }
    print(result+1)
}