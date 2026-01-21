fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = IntArray(366) {0}
    for(i in 0 until n) {
        val(a, b) = br.readLine().split(" ").map{it.toInt()}
        for(j in a..b) {
            arr[j]++
        }
    }
    var start = 0
    var flag = false
    var max = 1
    var res = 0
    for(i in 1..365) {
        if(!flag && arr[i]!=0) {
            max=maxOf(max, arr[i])
            if(i==365) {
                res+=max
            }
            start = i
            flag = true
        }else if(flag && i == 365&&arr[i]!=0) {
            max = maxOf(max, arr[i])
            res+= max*(i-start+1)
        }
        else if((flag &&arr[i]==0)) {
            res += max*(i-start)
            max = 1
            start = 0
            flag = false
        }
        else if(flag && arr[i]!=0) {
            max = maxOf(max, arr[i])
        }
    }
    print(res)
}