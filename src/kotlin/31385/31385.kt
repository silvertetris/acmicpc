import kotlin.math.sqrt

fun main() {
    val n = readln().toInt()
    val bw = System.out.bufferedWriter()
    /*
    a1+..+a_k까지
아무 k를 골랐을 때 -> n까지
-> 양의 약수가 있어야한다 a_k만큼의

1. 소수 판정
2. 제곱수 판정
2, 3 -> 아리스토태네 체
3. 누적합

홀수 규칙으로 하면 안됨

결국 약수의 개수를 구해야하긴 함

1 2 3 4
n이 10만개긴한데, 누적합의 한계는 어디까지인가??
제일 작은 약수인 2를 예시로 든다면 2^8은 약수의 개수가 8임
216은 1, 2, 3, 4, 6, 8, 9, 12, 24, 36, 54, 72, 108, 216
약수 -> 2^x * 3^y 일때, (x+1)(y+1)

그럼 약수의 개수가 최대 300개일수가 있나?
제곱수 +1 들끼리 의 곱이 300개까지 올라가야함
근데 3천만 까지는 안감 -
메모리 1기가 3천만을 잡아볼까
리미트는 11 => 3천만 까지 약수 최대 개수는 11개임
     */
    val limit = n*300
    val rootLimit = sqrt(limit.toDouble()).toInt()
    val divisors = IntArray(limit+1) {2}
    val isPrime = BooleanArray(limit+1) {true}
    isPrime[0] = false
    isPrime[1] = false
    divisors[0] = 0
    divisors[1] = 1
    //
    for(i in 2 .. limit) {
        for(j in i*2..limit step i) {
            divisors[j]++
            isPrime[j] = false
        }
    }

}