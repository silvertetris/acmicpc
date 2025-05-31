

fun main() {
    val n = readln().toInt()
    fun power(base: Long, exp: Long): Long {
        if (exp == 0L) return 1L
        val half = power(base, exp / 2)%1_000_000_007
        return if (exp % 2 == 0L) half * half%1_000_000_007 else half * half * base%1_000_000_007
    }
    print((power(2, n+2L)-5) %1_000_000_007)
}