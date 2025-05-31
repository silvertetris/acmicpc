

fun main() {
    val n = readln().toInt()
    val arr: Array<String> = Array<String>(n) { "" }
    val result: ArrayList<String> = ArrayList<String>()
    for (i in 0 until n) {
        arr[i] = readln()
        arr[i] = arr[i].reversed()
        var str = ""
        var set = mutableSetOf(arr[i])
        for (j in arr[i].indices) {
            str += arr[i][j]
            set.add(str)
        }
        for(j in set) {
            if(result.contains(j)) {
                result.remove(j)
            }
            else{
                result.add(j)
            }
        }
    }
    print(result.size)
}