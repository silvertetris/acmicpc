package kotlin

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val p:Int = sc.nextInt()
    val w:Int = sc.nextInt()
    val n:Int = sc.nextInt()
    //각 버블 수, 감염된 버블 수
    sc.nextLine()
    var split1 = sc.nextLine().split(" ")
    var split2 = sc.nextLine().split(" ")
    sc.close()
    var infectedP:Int
    var infectedW:Int
    if(split1.get(0)=="P") {
        infectedP = split1.get(1).toInt()
        infectedW = split2.get(1).toInt()
    } else{
        infectedP = split2.get(1).toInt()
        infectedW = split1.get(1).toInt()
    }
    if(p==1&&w==0) {
        println(p)
    } else if(w==1 && p==0) {
        println(w)
    } else{
        println((infectedP*p) + (infectedW * w) - (infectedP*infectedW))
    }


}