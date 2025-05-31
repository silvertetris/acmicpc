package kotlin

fun main() {
    val k = readln().toInt()
    var result = StringBuilder()
    for(i in 0 until k) {
        result.append("Data Set ${i+1}:\n")
        val(n, m) = readln().split(" ").map { it.toInt() }
        var sus:MutableSet<Int> = mutableSetOf()
        var arr:Array<Pair<Int, Int>> = Array<Pair<Int, Int>>(m) {Pair(0,0)}
        for(j in 0 until m) {
            val temp = readln().split(" ").map{it.toInt()}
            arr[j] = Pair(temp[0],temp[1])
        }
        val s = readln().toInt()
        for( j in 0 until m) {
            if(arr[j].first == s || arr[j].second == s) {
                sus.add(arr[j].first)
                sus.add(arr[j].second)
            }
        }
        sus.remove(s)
        result.append("${sus.sorted().joinToString(" ")}\n\n")
    }
    print(result)
}