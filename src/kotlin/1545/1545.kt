fun main() {
    val s = readln().toCharArray().sorted().toMutableList()
    /*
    겹치지 않게 만드는건 쉬움 -> 근데 사전순??
    1. 50^50 -> 무조건 초과
    2. 정렬하고 생 -> 2초기 때문에 정렬을 하고서 생각

    반으로 가르고서 기준을 잡아야하기 때문에, 앞부분이랑 뒷부분이랑 바꾸기?
    근데 만약 aaaaaaaab -> 불가능하기 때문에 안됨
    정렬된 상태에서 바꿔야 하는건 절반 기준으로 뒷대가리 애들
    그 중에서 앞에 있는 애들을 최대한 뒤에있는 놈하고 바꿔야함 -> 가능한한 앞쪽 (사전순)
    좌측을 바꿀 수 밖에 없는 경우가 있을까?
    -> aabbbb-> 이런건 불가능함 -> aaabbb(가능), aaaabb(불가능), aabbcc -> aabcbc (가능)
    -> aabaa 안됨 -> aaabc, 홀수면 걍 가운데 있는게 의미가 없는듯 abbbb (불가능 ) abbbc가능

    문제 -> 바꿨는데 같은 경우도 있음 -> 그냥 처음부터 다시 탐색
     */
    if (s.size == 1) {
        print(s[0])
        return
    }
    //2가지로 나누기 홀수, 짝수
    var descP = s.size / 2 - 1
    var incP = if(s.size%2==1) s.size / 2 + 1 else s.size / 2
    var flag = false
    for (i in 0 until s.size / 2) {//caution -> indexoutofrange
        if (s[descP - i] == s[incP + i]) {
            for (j in incP + i until s.size) {
                if (s[incP + i] != s[j]) {
                    val temp = s[incP + i]
                    s[incP + i] = s[j]
                    s[j] = temp
                    flag = true
                    break
                }
            }
            if (!flag) {
                print(-1)
                return
            } else {
                flag = false
            }
        }
    }
    print(s.joinToString(""))
}