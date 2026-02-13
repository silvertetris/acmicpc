fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val(n, m) = br.readLine().split(" ").map{ it.toInt() }
    val vertices = br.readLine().split(" ").map{ it.toInt() }.sorted()
    repeat(m) {
        val(start, end) = br.readLine().split(" ").map{ it.toInt() }.sorted()
        //start를 high bound 하고 end를 low bound
        var (l, r) = 0 to n-1
        var (u, v) = 0 to 0
        while(l<=r) {
            var mid = (l+r)/2
            if(vertices[mid]<start) {
                r=mid-1
            }
            else {
                l=mid+1
            }
        }
        u = l
        l =0
        r = n-1
        while(l<=r) {
            var mid = (l+r)/2
            if(vertices[mid]<end) {
                r=mid-1
            }
            else {
                l=mid+1
            }
        }
        v = r
        bw.write("${u-v}\n")
    }
    bw.flush()

}