fun main() {
    val br = System.`in`.bufferedReader()
    val(n, a, b) = br.readLine().split(" ").map { it.toInt() }
    val seq = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    /*
    왼손 오른손 -> 한 칸에 둘다 동시에 두기 가능
하지만 두 손 둘다 움직이기 불가능
위치이동, 정수를 누를 때마다 체력 사용
위치 이동시에 다른 두 칸 사이 거리만큼 체력 씀 -> 멘헤튼 거리
왼손 -> A체력
오른손 -> B체력

칸은 무조건 3*4
각 손 시작점은 1, 3번
눌러야하는 순서 주어짐
체력의 최소 값

#1. states/subproblems
dp[i][j][k] = i 번째 순서를 j번을 k 손으로 눌렀을 때??

     */
}