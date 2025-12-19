fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    /*
    i, j, k 층 행 열
     */

    val n = br.readLine().toInt()
    val hjk = Array(n) { IntArray(n) }
    val rik = Array(n) { IntArray(n) }
    val cij = Array(n) { IntArray(n) }
    val result = Array(n) { Array(n) { IntArray(n) { 1 } } }
    for (j in 0 until n) {
        val line = br.readLine()
        for (k in 0 until n) {//jk
            hjk[j][k] = line[k] - '0'
            if (line[k] - '0' == 0) {
                for (i in 0 until n) {
                    result[i][j][k] = 0
                }
            }
        }
    }
    for (i in 0 until n) {
        val line = br.readLine()
        for (k in 0 until n) {
            rik[i][k] = line[k] - '0'
            /*
            이게 안되는 이유
            그니까 0이면 무조건 없는게 맞은데, 저기서 1이나온건 -> 어차피 1일 가능성을 얘기하는거임 1이 아닐수도 있음
            적어도 1이 하나라도 있어야하는 것임
            모든 좌표계에 대해서 하나라도 1이 나오면 됨 그니까 지금 컨디션에서 정한 쪽이 아니더라도 다른 곳에서 1일수도 있음
            일단 0이면 0으로 대입하는게 맞음 근데 1일때가 이상함
            조건을 다시 정의하자면 (NO가 나오는)
            1 해당 범위에 대해 1이 있다? 그러면
            일단 모든 범위에 대해서 1을 확인해야함 -> 다 0이면 그때 NO를 뱉음 그니까 일단은 로직을 나눠야함
            1. 0으로 다 바꿀건 바꾼다
            2. 그 다음 1인걸 확인한다
             */
            if (line[k] - '0' == 0) {
                for (j in 0 until n) {
                    result[i][j][k] = 0
                }
            }
        }
    }

    for (i in 0 until n) {
        val line = br.readLine()
        for (j in 0 until n) {
            cij[i][j] = line[j] - '0'
            if (line[j] - '0' == 0) {
                for (k in 0 until n) {
                    result[i][j][k] = 0
                }
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            //그게 1이고 저기서 하나라도 1이 나오면 됨 근데 그게 3가지 다 돼야함
            var flag1 = false
            var flag2 = false
            var flag3 = false
            if (hjk[i][j] == 1) {
                for (k in 0 until n) {
                    if (result[k][i][j] == 1) {
                        flag1 = true
                        break
                    }
                }
            }
            if (rik[i][j] == 1) {
                for (k in 0 until n) {
                    if (result[i][k][j] == 1) {
                        flag2 = true
                        break
                    }
                }
            }
            if (cij[i][j] == 1) {
                for (k in 0 until n) {
                    if (result[i][j][k] == 1) {
                        flag3 = true
                        break
                    }
                }
            }
            if(!flag1 && hjk[i][j]==1) {
                print("NO")
                return
            }
            if(!flag2 && rik[i][j]==1) {
                print("NO")
                return
            }
            if(!flag3 && cij[i][j]==1) {
                print("NO")
                return
            }
        }
    }
    bw.write("YES\n")
    for (i in 0 until n) {
        for (j in 0 until n) {
            for (k in 0 until n) {
                bw.write(result[i][j][k].toString())
            }
            bw.write("\n")
        }
    }
    bw.flush()
}