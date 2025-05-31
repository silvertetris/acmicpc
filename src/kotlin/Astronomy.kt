

fun main() {
    var l = 0
    var t = 0
    for( i in 0 until 9 ) {
        var input = readln()
        if(input=="Lion") l++
        else t++
    }
    if(l>t) print("Lion")
    else print("Tiger")
}