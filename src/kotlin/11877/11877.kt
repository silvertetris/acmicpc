fun main() {
    val (n, x) = readln().split(" ").map { it.toLong() }
    val bw = System.out.bufferedWriter()
    /*
    히스토그램 -> h 순열
    -ideal
    n, n-1 사이에 끼고
사이에 있는 수를 뺴서 x를 맞추기
(n-1)(n-2)/2 -> 이게 최대 값 아닌가?

     */
    if (n == 1L || n == 2L) {
        print(-1)
        return
    }
    var init = (n - 1) * (n - 2) / 2
    if (init < x) {
        print(-1)
        return
    }
    //n-2 부터 1임
    //var diff = n-1-(init- x)//이걸 0으로 만들어야하니까 이만큼 버려야함 -> n-2 하나씩 내려갈수록 1이 추가
    var diff = init -x
    /*
    문제: 빼야할 수가 n에 있는 단일 숫자보다 큰 경우 -> 그니까 2개 이상의 카드를 써서 숫자를 줄어야할 경우
    while로 줄어야함
    어디서 찾냐? 1.. n-2까지의 수 중에서 찾아야함


     */
    bw.write("$n ")
    if(diff!=0L) {
        val used = mutableListOf<Int>()
        var flag = false
        var best = 0
        var fit = 0
        for(i in 1 .. n-2) {
            if(flag||(n-1-i)<=0) {
                bw.write("$i ")
            }
            else if((n-1-i)<diff ) {
                best = i.toInt()
                diff-=(n-i-1)
            }
            else if((n-1-i)-diff ==0L) {
                fit =i.toInt()
                flag = true
            } else {
                bw.write("$i ")
            }
        }
        bw.write("${n-1} ")
        bw.write("$fit ")
        for(i in best downTo 1) {
            bw.write("$i ")
        }
    }
    else {
        for(i in 1.. n-1) {
            bw.write("$i ")
        }
    }
    bw.flush()
    bw.close()

}