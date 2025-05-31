

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toLong() }.toMutableList()
    val k = br.readLine().toInt()

    fun sort(arr1: MutableList<Long>, arr2: MutableList<Long>): MutableList<Long> {
        var i = 0
        var j = 0
        val merged=MutableList<Long>(arr1.size+arr2.size) { 0 }
        var p = 0
        while(i<arr1.size && j<arr2.size) {
                if(arr1[i]<arr2[j]) {
                    merged[p++] = arr1[i++]
                } else {
                    merged[p++] = arr2[j++]
                }
        }
        while (i < arr1.size) merged[p++] = arr1[i++]
        while (j < arr2.size) merged[p++] = arr2[j++]
        return merged
    }

    fun split(arr: MutableList<Long>): MutableList<Long> {
        if (arr.size == n/(2*(k-1))) {
            return arr
        }
        val middle = arr.size / 2
        val left = split(arr.subList(0, middle))
        val right = split(arr.subList(middle, arr.size))
        return sort(left, right)
    }
    val result = split(arr)
    for(i in result.indices){
        print("${result[i]} ")
    }
}