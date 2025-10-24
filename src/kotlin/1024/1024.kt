fun main() {
    val (n, r, c) = readln().split(" ").map { it.toLong() }
    var size = 1L
    repeat(n.toInt()) {
        size *= 2
    }
    var answer = 0L
    var cnt = 0L
    fun divcon(size: Long, r: Long, c: Long, tr: Long, tc: Long) {
        if (r == tr && c == tc) {
            answer = cnt
            return
        }
        /*
        나눠야 하는 조건 -> 4등분으로 나눠야함 한쪽만 나누는건 안됨 -> 4등분으로 동시에 나눠야함 -> 한 등분 칸은 /2
        -> 그럼 주어진 로우 칼럼이 나눴을 때 로우 칼럼 범위 안에 들어가야함
        -조건
        1. (r, c)가 다음 탐색할거 범위 (tr+다음 분할 사이즈)에 들어있어야함
        2. 하지만 1번에 만족하려면 현재 tr, tc가 r, c,보다 작야야함 -> 예외처리임 이거 아니면 size다 더 커서 스오플 일어남
         */
        if (tr + size > r && tc + size > c && tr<=r && tc<=c) {
            divcon(size/2, r, c, tr, tc)//1
            divcon(size/2, r, c, tr, tc+size/2)//2
            divcon(size/2, r, c, tr+size/2, tc)//2\3
            divcon(size/2, r, c, tr+size/2, tc+size/2)//4
        } else {//저 조건 통과안되면 해당 블록은 이미 다 통과 -> 이때의 n, 2^n * 2^n만큼 이미 통과한거니까 더해줌
            cnt += size * size
        }
    }
    divcon(size, r, c, 0, 0)
    print(answer)
}