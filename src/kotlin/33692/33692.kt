fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    val binA = a.toString(2)
    val binB = b.toString(2)

    val sbA = StringBuilder(binA)//min
    val sbB = StringBuilder(binB)//max
    var flag = false
    var able = false
    if (binA.length < binB.length) {
        val diff = sbB.length - sbA.length
        for (i in 0 until diff) {
            if (sbB[i] == '0') {
                sbA.insert(i, '1')
            } else {
                sbA.insert(i, '0')
            }
        }
        for (i in 0 until sbA.length) {
            if (sbA[i] == sbB[i]) {
                sbB[i] = if (sbA[i] == '0') '1' else '0'
            }
        }
    } else {
        for (i in 0 until sbA.length) {
            if (!flag && sbA[i] == sbB[i]) {
                continue
            } else if (!flag && sbA[i] != sbB[i]) {
                flag = true
            } else if (flag && sbA[i] == sbB[i] &&!able) {
                sbA[i] = if (sbB[i] == '0') '1' else '0'
            }
        }
    }
    print("${sbA.toString().toLong(2)} ${sbB.toString().toLong(2)}")
}