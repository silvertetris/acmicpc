import kotlin.math.*

fun main() {
    fun fft(real: DoubleArray, img: DoubleArray, invert: Boolean) {
        val n = real.size
        var j = 0
        for (i in 1 until n) {
            var bit = n shr 1
            while (j and bit != 0) {
                j = j xor bit
                bit = bit shr 1
            }
            j = j or bit
            if (i < j) {
                val realTemp = real[i]
                val imgTemp = img[i]
                real[i] = real[j]
                img[i] = img[j]
                real[j] = realTemp
                img[j] = imgTemp
            }
        }
        var len = 2
        while (len <= n) {
            val ang = 2 * PI / len * if (invert) 1 else -1
            val wlengthReal = cos(ang)
            val wlengthImg = sin(ang)
            for (i in 0 until n step len) {
                var wReal = 1.0
                var wImg = 0.0
                for (k in 0 until len / 2) {
                    val evenSumationReal = real[i + k]
                    val evenSumationImg = img[i + k]
                    val oddSumationReal = real[i + k + len / 2] * wReal - img[i + k + len / 2] * wImg
                    val oddSumationImg = real[i + k + len / 2] * wImg + img[i + k + len / 2] * wReal
                    real[i + k] = evenSumationReal + oddSumationReal
                    img[i + k] = evenSumationImg + oddSumationImg
                    real[i + k + len / 2] = evenSumationReal - oddSumationReal
                    img[i + k + len / 2] = evenSumationImg - oddSumationImg
                    val resWReal = wReal * wlengthReal - wImg * wlengthImg
                    val resWImg = wReal * wlengthImg + wImg * wlengthReal
                    wReal = resWReal
                    wImg = resWImg
                }
            }
            len = len shl 1
        }
        if (invert) {
            for (i in real.indices) {
                real[i] = real[i] / n.toDouble()
            }
        }
    }

    fun conv(a: IntArray, b: IntArray): LongArray {
        var n = 1
        while (n < a.size + b.size) {
            n = n shl 1
        }
        val faReal = DoubleArray(n) {0.0}
        val faImg = DoubleArray(n) {0.0}
        val fbReal = DoubleArray(n) {0.0}
        val fbImg = DoubleArray(n) {0.0}
        for (i in a.indices) faReal[i] = a[i].toDouble()
        for (i in b.indices) fbReal[i] = b[i].toDouble()
        fft(faReal, faImg,false)
        fft(fbReal, fbImg,false)
        for (i in 0 until n) {
            //(a+bi) * (c+di) = ab-bd + adi + bci
            val temp1 = faReal[i] * fbReal[i] - faImg[i] * fbImg[i]
            val temp2 = faReal[i] * fbImg[i] + faImg[i] * fbReal[i]
            faReal[i] = temp1
            faImg[i] = temp2
        }
        fft(faReal, faImg,true)
        val len = a.size + b.size - 1
        return LongArray(len) { i -> (faReal[i] + 0.5).toLong() }
    }

    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val arr = IntArray(n) {0} //제곱수 표시 (n까지)
    for (i in 1 until n) {
        val r = ((i.toLong() * i) % n).toInt()//c^2 % n
        arr[r] = arr[r] + 1
    }

    val initCheck = conv(arr, arr)  // 길이 = 2n-1 -> 모든 경우의 수

    val el = LongArray(n) { k ->
        initCheck[k] + if (k + n < initCheck.size) initCheck[k + n] else 0L
    }// -> 주대각 원소, 아닌거 *2 (대칭성)

    val ml = LongArray(n) //주대각선 값
    for (i in 1 until n) {
        val t = ((2L * i * i) % n).toInt()
        ml[t]++
    }

    var answer = 0L
    for (c in 1 until n) {
        val t = ((c.toLong() * c) % n).toInt()
        answer += (el[t] + ml[t]) / 2 // 주대각선 *2 , 아닌거 *2 둘이 더해서 2로나눔 -> 1*(a==b), 1*(a<b)
    }

    print(answer)
}