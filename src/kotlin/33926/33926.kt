fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(m) { 0 } }
    val isBlack = Array(n) { BooleanArray(m) { false } }
    for (i in 0 until n) {
        arr[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    for (i in 0 until n) {
        val temp = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until m) {
            if (temp[j] == 1) {
                isBlack[i][j] = true
            }
        }
    }

    /*
    #1. states/ subproblems
    ldp[i][j] = i, j 인덱스에서 나올 수 있는 최소 공 개수
    rdp[i][j] = `` 최대 공 개수
    이렇게 나눈 이유: 아무래도 부호가 반대로 되기 때문에 가장 최소에서 -1을 곱하면 뻥튀기가 됨 -> 이를 고려 안했음
    떄문에 ldp를 토대로 최대가 나올 수 있는 rdp가 있기 때문에 ldp 처럼 2개의 dp 배열을 만들어도 되는 상황
     */
    val ldp = Array(n) { LongArray(m) { 0L } }
    val rdp = Array(n) { LongArray(m) { 0L } }
    //#2. Base Cases
    ldp[0][0] = arr[0][0].toLong()
    rdp[0][0] = arr[0][0].toLong()
    for (i in 1 until n) {
        if (!isBlack[i][0]) {
            ldp[i][0] = ldp[i - 1][0] + arr[i][0]
            rdp[i][0] = ldp[i][0]
        } else {
            ldp[i][0] = (ldp[i - 1][0] + arr[i][0]) * -1
            rdp[i][0] = ldp[i][0]
        }
    }
    for (i in 1 until m) {
        if (!isBlack[0][i]) {
            ldp[0][i] = ldp[0][i - 1] + arr[0][i]
            rdp[0][i] = ldp[0][i]
        } else {
            ldp[0][i] = (ldp[0][i - 1] + arr[0][i]) * -1
            rdp[0][i] = ldp[0][i]
        }
    }

    //#3. transiton
    for (i in 1 until n) {
        for (j in 1 until m) {
            if (!isBlack[i][j]) {
                ldp[i][j] = minOf(ldp[i - 1][j], ldp[i][j - 1], rdp[i - 1][j], rdp[i][j - 1]) + arr[i][j]
                rdp[i][j] = maxOf(ldp[i - 1][j], ldp[i][j - 1], rdp[i][j - 1], rdp[i - 1][j]) + arr[i][j]
            } else {
                ldp[i][j] = (maxOf(ldp[i - 1][j], ldp[i][j - 1], rdp[i - 1][j], rdp[i][j - 1]) + arr[i][j]) * -1
                rdp[i][j] = (minOf(ldp[i - 1][j], ldp[i][j - 1], rdp[i - 1][j], rdp[i][j - 1]) + arr[i][j]) * -1
            }
        }
    }

    //#4. final answer
    print(rdp[n - 1][m - 1])
}