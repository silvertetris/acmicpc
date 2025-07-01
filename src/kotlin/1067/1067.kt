import kotlin.math.*

/*data class Complex(val real: Double, val imag: Double) { //실수부 허수부
    operator fun plus(o: Complex)  = Complex(real + o.real,     imag + o.imag)
    operator fun minus(o: Complex) = Complex(real - o.real,     imag - o.imag)
    operator fun times(o: Complex) = Complex(
        real * o.real - imag * o.imag,
        real * o.imag + imag * o.real
    )
    operator fun div(d: Double)    = Complex(real / d, imag / d) // 나눗셈은 연산자가 실수인 것만 구현
}


/*
 * Cooley-Tuk FFT 구현 (in-place)
 *
 * 수학적 배경 및 삼각함수 연결:
 * -------------------------------------------------------------
 * 연속 푸리에 삼각급수: -> 삼각함수 공식
 *   f(x) = a_0/2 + Σ_{n=1..∞}[a_n cos(n x) + b_n sin(n x)]
 * 복소 지수 형태: -> 오일러 공식
 *   f(x) = Σ_{n=-∞..∞} X_n e^{i n x},
 *   여기서 X_n = (a_n - i b_n)/2 (n>0), X_{-n}=(a_n + i b_n)/2
 *
 * 이산 푸리에 변환(DFT): -> 적분은 못하니까 각 값에 대한 이산 연산
 *   X[k] = Σ_{j=0..N-1} x[j]·e^{-2πi·j·k/N}
 *    = Σ_{j=0..N-1} x[j]·[cos(2πjk/N) - i sin(2πjk/N)]
 *
 * 역변환(IDFT): -> 계수 구하기, 오일러식에 의해 삼각함수공식의 두 계수가 하나로 통합
 *   x[j] = (1/N)Σ_{k=0..N-1} X[k]·e^{+2πi·j·k/N}
 *
 */

//Cooley Tukey fft algorithm
fun fft(a: Array<Complex>, invert: Boolean) {
    val n = a.size
    // a_n, b_n => x_n (짝수부 홀수부 나누기 위한 비트 log(n) 알고리즘 -> %2 보다는 효율적)
    var j = 0
    for (i in 1 until n) {
        var bit = n shr 1
        while (j and bit != 0) {
            j = j xor bit
            bit = bit shr 1
        }
        j = j or bit
        if (i < j) a[i] = a[j].also { a[j] = a[i] }
    }
    //푸리에 변환 연산 -> 계수 연산 x_n
    var len = 2
    while (len <= n) {
        val ang  = 2*PI/len * if (invert) 1 else -1 //w -> 2*pi*f
        val wlen = Complex(cos(ang), sin(ang))
        for (i in 0 until n step len) {
            var w = Complex(1.0, 0.0)
            for (k in 0 until len/2) {
                val u = a[i+k]
                val v = a[i+k+len/2] * w
                a[i+k]          = u + v
                a[i+k+len/2]    = u - v
                w = w * wlen
            }
        }
        len = len shl 1
    }
    // x_n -> X_n
    if (invert) {
        for (i in a.indices) a[i] = a[i] / n.toDouble()
    }
}

//합성곱 (fft로)
fun convolution(a: LongArray, b: LongArray): LongArray {
    var N = 1
    while (N < a.size + b.size) N = N shl 1
    val fa = Array(N) { Complex(0.0, 0.0) }
    val fb = Array(N) { Complex(0.0, 0.0) }
    for (i in a.indices) fa[i] = Complex(a[i].toDouble(), 0.0)
    for (i in b.indices) fb[i] = Complex(b[i].toDouble(), 0.0)
    fft(fa, false)
    fft(fb, false)
    for (i in 0 until N) fa[i] = fa[i] * fb[i]
    fft(fa, true)
    val res = LongArray(N)
    for (i in res.indices) res[i] = (fa[i].real + 0.5).toLong()
    return res
}

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val x = br.readLine().split(" ").map { it.toLong() }
    val y = br.readLine().split(" ").map { it.toLong() }
    val revY = LongArray(n) { i -> y[n - 1 - i] }
    val conv = convolution(x.toLongArray(), revY) //x, 역변환 y -> 합성곱
    var answer = Long.MIN_VALUE
    for (k in 0 until n) {
        val base = conv[n - 1 - k]
        val wrap = if (k > 0) conv[n - 1 - k + n] else 0L
        answer = max(answer, base + wrap)
    }
    print(answer)
}
*/