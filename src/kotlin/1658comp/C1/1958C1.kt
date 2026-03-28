fun main() {
    val br= System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    //오일러 피 는 아니고 gcd 구현?
    /*
    백트래킹?
    예제도 이해안감 저게 왜서로소임 최대공약수가 1이 아닌데
    가 아니라 모든 수 집합 최대 공약수가 1이다 -> constructive
    1 2 3 4 5 6 7 8 9
    3의 배수에 위반되네
    -> n이랑 나누어 떨어지는 열을 조심 해야함
    3의 배수인놈만 한칸 이동? 만약 짝수면 위배 되나?
    아니지 그냥 맨 첫줄에 있는 에만 바꾸면 될거 같음 -> 두번째줄
    %n 했을떄 0인애를 다른위치로 어떤곳으로 근데?
    1 2 3 4 5 6 7 8 9
    1 2 3 4 5 6 7 8 9
    3 1 2 6 5 4 9 7 8
    55 56 57
     */
    repeat(t) {
        val n = br.readLine().toInt()
        val arr = Array(n*n) {IntArray(n*n) {0} }
        var cnt = 1
        for(i in 0 until n*n) {
            for(j in 0 until n*n) {
                arr[i][j] = cnt
                cnt++
            }
        }
        for(i in 0 until n* n step n) {
            //그니까 n배수에 있는애를 맨앞으로 가져와야함
            val temp = arr[1][n+i-1]
            //왜 i, i+1 인덱스에 같은 숫자가 들어갈까??? -> 아니 처음 i가 갱신이 안됐잖아
            for(j in n+i-1 downTo  i+1) {
                arr[1][j] = arr[1][j-1]
            }
            arr[1][i] = temp
        }
        for(i in 0 until n*n) {
            bw.write("${arr[i].joinToString(" ")}\n")
        }
    }
    bw.flush()

}