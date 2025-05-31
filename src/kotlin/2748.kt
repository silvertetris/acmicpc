package kotlin

fun main() {
    var arr = MutableList<Long> (100){0L}
    fun dp(num:Long):Long {
        if(num==0L || num == 1L) {
            return num
        }
        if(arr[num.toInt()]!=0L) {
            return arr[num.toInt()]
        }
        arr[num.toInt()] = dp(num-1) + dp(num-2)
        return arr[num.toInt()]
    }

    val n = readln().toInt()
    print(dp(n.toLong()))
}