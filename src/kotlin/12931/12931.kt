package kotlin.`12931`

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.sorted().toMutableList()
    var ans = 0
    while(true) {
        if(arr.sum()==0) {
            break
        }
        for(i in 0 until n) {
            if(arr[i]%2!=0) {
                ans++
                arr[i]--
            }
        }
        if(arr.sum()==0) {
            break
        }
        for(i in 0 until n) {
            arr[i]/=2
        }
        ans++
        if(arr.sum()==0) {
            break
        }
    }
    print(ans)
}