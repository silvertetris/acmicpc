fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val mech = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val m = br.readLine().toInt()
    /*
    그니까 p를 입력하면 k개의 양을 p만큼 복제
    p는 항상 소수여야함
    복제기계에는 최대 양의 개수가 정해져 있음
    enter -> 모든 조수에게 p 입력
    각 기계에는 1스타트
    명령을 최대한 적게 외쳐야함 enter, clone 포함해서
    clone 안에 뒤에 숫자를 넣을 수 있는 최대 개수가 m임
    모든 기계를 최대값으로 만들어야하네?
     */
}