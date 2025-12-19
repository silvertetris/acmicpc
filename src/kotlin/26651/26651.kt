import kotlin.math.sqrt

fun main() {
    var x= readln().toInt()
    /*
    전체 문자열의 갯수가 10만이하여야하는데
부분 문자열의 개수가 10^9인 경우의 수가 있나?

AB일때 1
AAB이면 2
AABB면
4개
AAABB
1. AB
2. ABB
3. AAB
4. AABB
5. AAAB
6. AAABB
6개
AAABBB면
1. AB
2. AAB
3. ABB
4. AABB
5. ABBB
6. AAAB
7. AAABB
8. AABBB
9. AAABBB
9개
AAAABBBB면
모두 포함한 9개에
7개짜리부터
1. AAAABBB
2. AAABBBB
그리고 위에 7번부터 달라진거 더
3. AAAAB
4. ABBBB
5. AAAABB
6. AABBBB
7. AAAABBBB
다 더해서 총 16개
-> 제곱의 형태가됨
그럼 일단 추가된 것에 대해서 둘이 곱한 형태 -> 종속된 변수 -> 둘이 + 형태가 아닌 제곱이나 곱의 형태로 종속됨

반대편에 1개당
0개는 아무거나 출력
기본 베이스는 1개
앞에 1개면 2개됨 (추가된 횟수)
1인 상태에서 뒤에 1추가 (2배됨 AABB이면 4개)
양쪽에 같이 추가할수록 9개, 16개
y=(x+1)(y+1) <-- 이 식으로 가정 AAABB일 경우 답이 6 나와야함
1. AB
2. AAB
3. ABB
4. AABB
5. AAAB
6. AAABB
증명 완
제곱이기 때문에 10^5 개수로 제곱하면 1억개 경우의 수 넘기 가능
     */
    val base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    if(x==0) {
        print("A")
        return
    }
    val bw = System.out.bufferedWriter()
    val counts = mutableListOf<Pair<Int, Int>>()
    while(true) {
        val mul = sqrt(x.toDouble()).toInt()
        //2라면 양쪽에 1개씩만 추가 (-1)
        x-=mul*mul
        if(x<0) {
            x+=mul*mul
            break
        }
        counts.add(mul-1 to mul-1)
        if(x==0) {
            break
        }
    }
    if(x>0) {
        counts.add(x-1 to 0)
    }
    for((x, y) in counts) {
        for(i in 0 until x) {
            bw.write("A")
        }
        bw.write(base)
        for(i in 0 until y) {
            bw.write("Z")
        }
    }
    bw.flush()
}