import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    val str = Array(7) { Pair(' ', 1) }
    str[0] = Pair('I', 1)
    str[1] = Pair('V', 5)
    str[2] = Pair('X', 10)
    str[3] = Pair('L', 50)
    str[4] = Pair('C', 100)
    str[5] = Pair('D', 500)
    str[6] = Pair('M', 1000)

    val roman = Array(4) { Array(4) { "" } }
    roman[3] = arrayOf("I", "IV", "V", "IX")
    roman[2] = arrayOf("X", "XL", "L", "XC")
    roman[1] = arrayOf("C", "CD", "D", "CM")
    val num = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
    repeat(t) {
        val n = br.readLine()
        if (num.contains(n[0])) {
            for (i in 0 until n.length) {
                val temp = n[i] - '0'//숫자 판단
                val digit = abs(n.length-4)
                if (digit+i==0) {//고치기
                    for (i in 0 until temp) {6
                        bw.write("M")
                    }
                } else {
                    when (temp) {
                        in 1..3 -> {
                            for (j in 0 until temp) {
                                bw.write(roman[digit+i][0])
                            }
                        }

                        4 -> {
                            bw.write(roman[digit+i][1])
                        }

                        in 5..8 -> {
                            bw.write(roman[digit+i][2])
                            for (j in 0 until temp - 5) {
                                bw.write(roman[digit+i][0])
                            }
                        }

                        9 -> {
                            bw.write(roman[digit+i][3])
                        }
                    }
                }

            }
            bw.write("\n")
        } else {
            var ans = 0
            if(n.length==1) {
                ans = str[str.indexOfFirst {it.first ==n[0]}].second
            }
            else {
                for (i in 1 .. n.lastIndex) {
                    val first = str.indexOfFirst {it.first == n[i]}
                    val second = str.indexOfFirst {it.first == n[i-1]}
                    if(first>second) {
                        ans += str[first].second - str[second].second
                        if(i!=1) {
                            ans -=str[second].second
                        }
                    }
                    else {
                        ans +=str[first].second
                        if(i==1) {
                            ans+=str[second].second
                        }
                    }
                }
            }
            bw.write("$ans\n")
        }
    }
    bw.flush()
    bw.close()
    br.close()
}