fun main() {
    val(a, b, c) = readln().split(" ").map { it.toInt() }
    fun pow(a:Int, b:Int) : Long{
        if(b==0) return 1
        else if(b%2==0) {
            val p = pow(a, b/2)
            return 1L * p*p%c
        }
        else {
            val p = pow(a, (b-1)/2)
            return 1L * p*p % c * a % c
        }
    }
    print(pow(a, b))
}