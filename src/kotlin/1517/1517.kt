fun main() {
    fun merge(a: LongArray, tmp: LongArray, left: Int, mid: Int, right: Int): Long {
        var i = left
        var j = mid + 1
        var k = left
        var invCount = 0L

        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++]
            } else {
                tmp[k++] = a[j++]
                invCount += (mid - i + 1)
            }
        }
        // 남은 부분 복사
        while (i <= mid) tmp[k++] = a[i++]
        while (j <= right) tmp[k++] = a[j++]

        // 정렬된 부분을 원본 배열에 복사
        for (idx in left..right) {
            a[idx] = tmp[idx]
        }
        return invCount
    }

    fun mergeSort(a: LongArray, tmp: LongArray, left: Int, right: Int): Long {
        if (left >= right) return 0L
        val mid = (left + right) ushr 1
        var cnt = 0L
        cnt += mergeSort(a, tmp, left, mid)
        cnt += mergeSort(a, tmp, mid + 1, right)
        cnt += merge(a, tmp, left, mid, right)
        return cnt
    }

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = LongArray(n)
    for (i in 0 until n) {

        arr[i] = br.readLine().toLong()
    }
    val tmp = LongArray(n)
    val swapCount = mergeSort(arr, tmp, 0, n - 1)

    bw.write(swapCount.toString())
    bw.flush()
}


