package kotlin

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    sc.nextLine()
    val factors = "9379379"
    val input:ArrayList<String> = ArrayList<String>()
    val result:ArrayList<String> = ArrayList<String>()
    for(i in 0 until n) {
        input.add(sc.nextLine())
    }
    for(i in 0 until n) {
        var products:Int = 0
        var index:Int =0
        var temp:Int=0
        var temp1:Int =0
        for(j in input[i].length-1 downTo 0) { //끝 인덱스 부터 0 까지 input[i]를 탐색
            val digit = input[i][j].code - 48 //숫자로 변환 해당 인덱스
            if(digit==15) { //물음표면 해당 인덱스 탐색
                index=j //물음표인 인덱스 값
                temp1=temp
                temp++
                continue
            }
            products+=digit*(factors[temp].code-48) //factor을 끝부터 탐색 여기도 틀림
            temp++
        }
        for(j in 0..9) {
            //index = 물음표의 자리
            //그니까 facotrs 는 6인덱스 까지
            val multiplied = (factors[temp1].code - 48) * j //여기가 문제임
            if((products+multiplied)%10==0) {//맞으면 j가 답
                var arr:CharArray = input[i].toCharArray()
                arr[index] = (j+48).toChar()
                result.add(String(arr))
                break
            }
        }
    }

    for(i in 0 until n) {
        println("Scenario #${i+1}:")
        println(result[i])
        if(i!=n-1) {
            println()
        }
    }
}