fun main() {
    val br = System.`in`.bufferedReader()
    val (n,s) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var l = 0
    var r = 0
    var result = n+2
    var sum = 0L
    while(l<n) {
        if(sum >=s) { //반대로 생각 같거나 크면 왼쪽을 증가
            result = minOf(result, r-l)
            sum-=arr[l++]
        }
        else {
            if(r<n) {//아니고, n보다 작음이 성립하면 우 증가 -> 이탈해도 break
                sum += arr[r++]
            } else {
                break
            }
        }
    }
    if(result == n+2) {
        print(0)
    } else {
        print(result)
    }
}