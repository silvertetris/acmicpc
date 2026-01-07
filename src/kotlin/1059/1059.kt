fun main() {
    val br = System.`in`.bufferedReader()
    val l = br.readLine().toInt()
    val s = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val n = br.readLine().toInt()
    s.sort()
    var small = 0
    var big = 1000
    for(i in 0 until s.size) {
        if(s[i]==n) {
            print(0)
            return
        }
        if(s[i]<n) small = s[i]
        if(s[i]>n) {
            big = s[i]
            break
        }
    }
    //x*y -1
    print((big-n)*(n-small) -1)
}