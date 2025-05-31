

import java.util.*

fun main() {
    val sc= Scanner(System.`in`)
    val t = sc.nextInt()
    val result:ArrayList<Int> = ArrayList<Int>()
    for(i in 0 until t) {
        val n = sc.nextInt()
        val m = sc.nextInt()
        val q = sc.nextInt()
        var resultInt = 0
        val torn:Array<Int> = Array(m) {0}
        for(j in 0 until m) {
            torn[j] = sc.nextInt()
        }
        val reader:Array<Int> = Array(q) {0}
        for(j in 0 until q) {
            reader[j] = sc.nextInt()
        }
        for(j in reader.indices) {
            resultInt += n/reader[j]
            for(k in torn.indices) {
                if(torn[k]%reader[j]==0) {
                    resultInt--
                }
            }
        }
        result.add(resultInt)
    }
    for(i in 0 until t) {
        println("Case #${i+1}: ${result[i]}")
    }
}