

fun main() {
    data class Stage(val a: Int, val b: Int, var done1: Boolean = false, var done2: Boolean = false)
    val n = readln().toInt()
    val stages = Array(n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        Stage(a, b)
    }

    var stars = 0
    var plays = 0
    var completed = 0

    while (completed < n) {
        var progressed = false

        // 2star
        for (stage in stages) {
            if (!stage.done2 && stage.b <= stars) {
                stars += if (stage.done1) 1 else 2
                stage.done2 = true
                stage.done1 = true
                plays++
                completed++
                progressed = true
                break
            }
        }

        if (progressed) continue

        // 1star
        var best: Stage? = null
        for (stage in stages) {
            if (!stage.done1 && stage.a <= stars) {
                if (best == null || stage.b > best.b) {
                    best = stage
                }
            }
        }

        if (best != null) {
            best.done1 = true
            stars += 1
            plays++
        } else {
            println("Too Bad")
            return
        }
    }

    println(plays)
}
