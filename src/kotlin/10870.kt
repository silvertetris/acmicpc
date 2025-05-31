package kotlin

fun main() {
    val n = readln().toInt()
    val arr = MutableList<Int>(21) {0}
    fun dp(num:Int):Int {
        if(num==1|| num==0) return num
        if(arr[num]!=0) return arr[num]
        arr[num] = dp(num-2)+dp(num-1)
        return arr[num]
    }
    print(dp(n))
}