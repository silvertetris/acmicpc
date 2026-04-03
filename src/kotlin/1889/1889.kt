import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val graph = Array(n) {mutableListOf<Int>()}
    val indegree = IntArray(n) {0}
    for(i in 0 until n) {
        //i가 a, b에게 선물을 줌
        val (a, b) = br.readLine().split(" ").map{it.toInt()}
        graph[i].add(a-1)
        graph[i].add(b-1)
        indegree[a-1]++
        indegree[b-1]++
    }
    /*
    각 자리가 a, b에게 선물을 주니까
    차수는 누구를 늘려야 하나? 받는 쪽은 a, b
    목표: 최대한 많은 학생을 살리면서 모든 학생의 차수가 2여야함
    작은놈 싹다 없애는게 과연 최적일까?
     */
    val isRemain = BooleanArray(n) {true}
    val queue: Queue<Int> = LinkedList()
    for(i in 0 until n) {
        if(indegree[i] <2) {
            queue.add(i)
            isRemain[i]=false
        }
    }
    while(queue.isNotEmpty()) {
        val cur = queue.poll()
        for(nei in graph[cur]) {
            if(isRemain[nei]) {
                indegree[nei]--
                if(indegree[nei]<2) {
                    isRemain[nei]=false
                    queue.add(nei)
                }
            }
        }
    }
    val cnt = isRemain.count{it}
    bw.write("$cnt\n")
    if(cnt!=0) {
        for(i in 0 until n) {
            if(isRemain[i]) {
                bw.write("${i+1} ")
            }
        }
    }
    bw.flush()
}