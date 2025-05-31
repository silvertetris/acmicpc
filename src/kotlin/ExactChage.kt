

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val a = sc.nextInt()
    val b= sc.nextInt()
    val arr: ArrayList<Int> = ArrayList()

    for(i in a .. b) {
        for(j in 2 .. i) {
            if(i.toDouble()%j==0.0 && !arr.contains(j)){
                arr.add(j)
                break
            }
            else if(i.toDouble()%j==0.0 && arr.contains(j)) {
                break
            }
        }
    }
    print(arr)
}