fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    if(n ==1) {
        print(1)
    }
    else if(n==2){
        print(minOf(4, (m+1)/2))
    }
    else if(m<7) {
        print(minOf(4, m))
    }
    else {
        print(m-2)
    }
}