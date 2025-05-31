package kotlin

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n: Int = sc.nextInt()
    sc.nextLine()
    val students: HashMap<String, Int> = HashMap()

    for (i in 0 until n) {
        students[sc.next()] = 0
    }
    sc.nextLine()
    for (i in 0 until n) {
        val arr: ArrayList<String> = ArrayList()
        arr.addAll(sc.nextLine().split(" "))
        for (j in 0 until arr.size) {
            students[arr[j]]?.inc()?.let { students.replace(arr[j], it) }
        }
    }
    val sortedStudents = students.entries
        .sortedWith(compareByDescending<Map.Entry<String, Int>> { it.value }
            .thenBy { it.key })

    for ((key, value) in sortedStudents) {
        println("$key $value")
    }
}