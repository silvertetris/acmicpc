import kotlin.math.cos
import kotlin.math.sin

/*
int k 에 대해 (i, j) 는 k-inversion -> s[i] = B, s[j] = A && j-i = K 인 경우만
각 거리는 k -> j 가 더 커야함
-> 일일히 하면 tle -> 순환 이동 -> fft
*/
fun main() {
    // Cooley–Tukey algorithm using primitive arrays
    fun fft(real: DoubleArray, imag: DoubleArray, invert: Boolean) {
        val n = real.size
        var j = 0
        for (i in 1 until n) { // 비트 반전
            var bit = n shr 1
            while (j and bit != 0) {
                j = j xor bit
                bit = bit shr 1
            }
            j = j or bit
            if (i < j) {
                real[i] = real[j].also { real[j] = real[i] }
                imag[i] = imag[j].also { imag[j] = imag[i] }
            }
        }

        var len = 2
        // butterfly 연산 -> 복소평면에서 시간-원 그리기 -> twiddle factor 계산
        while (len <= n) { //여기도 싹다 다시 구현
            val ang = 2 * Math.PI / len * if (invert) 1 else -1
            val wlenR = cos(ang)
            val wlenI = sin(ang)
            for (i in 0 until n step len) {
                var wR = 1.0
                var wI = 0.0
                for (k in 0 until len / 2) {
                    val uR = real[i + k]
                    val uI = imag[i + k]
                    // val v = a[i + k + len / 2] * w
                    val vR = real[i + k + len / 2] * wR - imag[i + k + len / 2] * wI
                    val vI = real[i + k + len / 2] * wI + imag[i + k + len / 2] * wR
                    real[i + k] = uR + vR
                    imag[i + k] = uI + vI
                    real[i + k + len / 2] = uR - vR
                    imag[i + k + len / 2] = uI - vI
                    // w *= wlen
                    val mulWR = wR * wlenR - wI * wlenI
                    val mulWI = wR * wlenI + wI * wlenR
                    wR = mulWR
                    wI = mulWI
                }
            }
            len = len shl 1
        }

        if (invert) {
            for (i in real.indices) { //실수로 나누기
                real[i] /= n.toDouble()
                imag[i] /= n.toDouble()
            }
        }
    }

    fun convolution(a: IntArray, b: IntArray): IntArray {
        var n = 1
        while (n < a.size + b.size - 1) n = n shl 1 //사이즈 최적화하기
        //Complex 형 class 제거 -> double형 array여러개로 받고 계산
        val ra = DoubleArray(n) { if (it < a.size) a[it].toDouble() else 0.0 }
        val ia = DoubleArray(n) { 0.0 }
        val rb = DoubleArray(n) { if (it < b.size) b[it].toDouble() else 0.0 }
        val ib = DoubleArray(n) { 0.0 }

        fft(ra, ia, false)
        fft(rb, ib, false)
        for (i in 0 until n) { //곱하기 따로 구현
            val mulR = ra[i] * rb[i] - ia[i] * ib[i]
            val mulI = ra[i] * ib[i] + ia[i] * rb[i]
            ra[i] = mulR
            ia[i] = mulI
        }
        fft(ra, ia, true) // ifft

        val res = IntArray(a.size + b.size - 1)
        for (i in res.indices) res[i] = (ra[i] + 0.5).toInt()
        return res
    }

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val s = br.readLine()
    br.close()
    val n = s.length
    val a = IntArray(n) { i -> if (s[i] == 'B') 1 else 0 }
    val b = IntArray(n) { i -> if (s[i] == 'A') 1 else 0 }.reversedArray()
    val answer = convolution(a, b)
    for (k in n - 2 downTo 0) {//1 until n => answer.reversed
        bw.write("${answer[k]}\n")
    }
    bw.flush()
    bw.close()
}
