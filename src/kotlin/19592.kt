package kotlin

fun main() {
    val t = readln().toInt()
    val bw = System.out.bufferedWriter()

    fun binarySearch(max: Int, me: Int, y:Int, x:Int): Int {
        var answer = -1
        var low = 0
        var high = y
        var vTime: Double = x.toDouble()/max.toDouble()
        while (low <= high) {
            var bool: Boolean
            val mid = (low + high) / 2
            val afterBoost = x - mid //1초후 부스트 쓰고 남은 거리
            var meTime:Double = afterBoost.toDouble()/me.toDouble()+1.0
            if (meTime > vTime) {
                low=mid+1
                bool = true
            } else if (meTime < vTime) {
                bool=false
                high=mid-1
            } else { //같을 경우
                answer = mid+1
                break
            }
            if(bool) {
                answer=mid+1
            }else {
                answer=mid
            }
        }
        return if(answer<=y) {
            answer
        }
        else -1
    }
    repeat(t) {
        val (n, x, y) = readln().split(" ").map { it.toInt() }
        var v = readln().split(" ").map { it.toInt() }.toMutableList()
        val me = v.last()
        v.removeLast()
        v.sort()
        val max = v.last()
        if (max < me) {
            bw.write("0\n")
        }else if(max==me) {
            bw.write("${max+1}\n")
        }
        else {
            bw.write("${binarySearch(max, me, y, x)}\n")
        }
    }
    bw.flush()
    bw.close()
}