package kotlin.`1071`

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.sorted().toMutableList()
    val isUsed = BooleanArray(53) { false }
    var prev = -1 //체크용 변수

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (isUsed[j] || prev + 1 == arr[j]) continue
            var flag = true
            for (k in 0 until n) {
                if (isUsed[k] || k == j || arr[k] == arr[j]) continue
                if (arr[k] != arr[j] + 1) {
                    flag = false
                    break
                }
            }
            if (flag) continue
            isUsed[j] = true
            print("${arr[j]} ")
            prev = arr[j]
            break
        }
    }

    for (i in 0 until n) {
        if (!isUsed[i]) print("${arr[i]} ")
    }
}