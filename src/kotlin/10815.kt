package kotlin

fun main() {
    val n = readln().toInt()
    var have = readln().split(" ").map { it.toInt() }.toMutableList()
    val m = readln().toInt()
    var find = readln().split(" ").map { it.toInt() }.toMutableList()
    have.sort()
    var result = Array(m){0}
    fun binarySearch(nums:MutableList<Int>, target:Int) : Int {
        val answer = 0
        var low = 0
        var high = nums.lastIndex
        while (low <= high) { //서로 교차하면 그만 둠
            val mid = (low + high) / 2

            if (nums[mid] < target) {
                low = mid + 1//찾으려는 수보다 iterator 가 더 작으면 low를 ++ => mid의 값이 올라감
            } else if (nums[mid] > target) {
                high = mid - 1
            } else {
                return 1
            }
        }
        return answer
    }
    for(i in 0 until m) {
        result[i] = binarySearch(have,find[i])
    }
    print(result.joinToString(" "))
}