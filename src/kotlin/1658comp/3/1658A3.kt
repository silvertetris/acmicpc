fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    /*
    무조건 dp 문제인데,그떄 코포 스테미나 문제?
    수를 나눈다? 어떻게?
    백트래킹 dp? -> 만점에서부터? 메모리는 안터질거 같음 -> transition은?
    받을 수 있는지 없는지에 대한 전이? -> 근데 2d 배열을 메모리 터짐

    #1. states/ subproblems
    dp[i][j]= i점수에서 j 만큼 노트 쳤을때 i 점수를 받을 수 있는지 없는지
    이러면 dp 가 안되는데 간단히 생각 ㄱㄱ
     해당 점수냐, 아니면 그거에 2배냐 아니면 2배에서 1를 더한거냐 -> 어차피 1은 나눠지면 의미가 없음

     */
    repeat(t) {
        val (n, s) = br.readLine().split(" ").map{it.toInt()}
        if(s!= 10_000_000 + n) {
            bw.write("No\n")
        } else {
            bw.write("Yes\n")
        }
    }
    bw.flush()
}