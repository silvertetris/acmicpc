import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val totalWeeks = m / 7
    // 각 유튜버별로 [주차][0: 횟수, 1: 총 시간(분)]을 저장
    // 이름 -> Array(주차수) { IntArray(2) }
    val userStats = HashMap<String, Array<IntArray>>()

    repeat(n) {
        val line = StringTokenizer(br.readLine())
        val name = line.nextToken()
        val day = line.nextToken().toInt()
        val startStr = line.nextToken().split(":")
        val endStr = line.nextToken().split(":")

        val weekIdx = (day - 1) / 7
        val startTime = startStr[0].toInt() * 60 + startStr[1].toInt()
        val endTime = endStr[0].toInt() * 60 + endStr[1].toInt()
        val duration = endTime - startTime

        // 해당 유튜버의 데이터 초기화
        val stats = userStats.getOrPut(name) { Array(totalWeeks) { IntArray(2) } }

        // 해당 주차에 데이터 누적
        stats[weekIdx][0] += 1        // 방송 횟수 증가
        stats[weekIdx][1] += duration // 방송 시간 추가
    }

    val realVirtualYoutubers = mutableListOf<String>()

    for ((name, stats) in userStats) {
        var isReal = true
        // 모든 주차를 순회하며 조건 확인
        for (w in 0 until totalWeeks) {
            val count = stats[w][0]
            val totalMinutes = stats[w][1]

            if (count < 5 || totalMinutes < 3600) {
                isReal = false
                break
            }
        }

        if (isReal) {
            realVirtualYoutubers.add(name)
        }
    }

    if (realVirtualYoutubers.isEmpty()) {
        println("-1")
    } else {
        realVirtualYoutubers.sort()
        realVirtualYoutubers.forEach {
            bw.write("$it\n")
        }
    }
    bw.flush()
    bw.close()
}