

fun main() {
    val n = readln().toInt()
    val s = readln()
    var answer = 0
    if(s[0] == 'W') {
        answer = 1
    }
    for(i in 1 until n) {
        if(s[i] == 'W' && s[i-1] =='W') {
            continue
        } else if(s[i]=='W') {
            answer ++
        }
    }
    if(answer == 0) {
        print(1)
    }else if(s.last()=='E') {
        print(answer+1)
    }else {
        print(answer)
    }
}