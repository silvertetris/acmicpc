import java.util.Deque
import java.util.LinkedList

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()
    val apple = Array(n + 1) { BooleanArray(n + 1) { false } }
    for (i in 0 until k) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        apple[temp[0]][temp[1]] = true
    }
    val l = br.readLine().toInt()
    val change = Array(10001) { 'X' } //idx = second, val = change
    for (i in 0 until l) {
        val temp = br.readLine().split(" ")
        change[temp[0].toInt()] = temp[1][0]
    }
    br.close()
    val dx = intArrayOf(0, 1, 0, -1) //상 우 하 좌
    val dy = intArrayOf(1, 0, -1, 0)//0 1 2 3
    val arr = Array(n + 1) { BooleanArray(n + 1) { false } }
    //그니까 보통 배열이 좌측 아래에서 시작하는데 문제는 좌측 상단이니까 오른쪽으로 꺾는다는게 진짜 오른쪽으로 꺾으면 안됨 한번 생각해야함
    //상하 반전으로만 생각해서, 우측 방향 기준으로 우로꺾으면 위로, 좌로 꺾으면 아래로 가야함
    arr[1][1] = true
    var count = 0
    var dir = 1
    val queue: Deque<Pair<Int, Int>> = LinkedList()
    queue.add(1 to 1)
    while (true) {
        val cur = queue.peek()
        count ++ //이동
        //그니까 뱀의 몸은 먼저 늘어나고 -> 사과 먹고 -> 그에 따라 유지할지 말지 정함
        val nextRow = cur.first + dy[dir]
        val nextCol = cur.second + dx[dir]
        if(nextRow !in 1.. n || nextCol !in 1..n) {//벽에 박으면 끝
            break
        }
        if (arr[nextRow][nextCol]) { //몸에 박아도 끝
            break
        }
        arr[nextRow][nextCol] = true //몸 길이를 먼저 늘림
        queue.addFirst(nextRow to nextCol) //순서대로 추가함
        if (!apple[nextRow][nextCol]) { //사과 있는지
            val tail = queue.pollLast() //없으면 꼬리 뺌
            arr[tail.first][tail.second] = false
        } else {
            apple[nextRow][nextCol] = false //사과만 없앰
        }
        if (change[count] == 'L') {
            dir = (4 - dir - 1) % 4
        } else if (change[count] == 'D') {
            dir = (dir + 1) % 4
        }
    }
    print(count)
}