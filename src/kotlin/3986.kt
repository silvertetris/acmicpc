package kotlin

import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var cnt = 0
    repeat(n) {
        val word = br.readLine()
        val stack = Stack<Char>()
        for(i in word.indices) {
            if(stack.isNotEmpty()&& stack.peek() == word[i]) {
                stack.pop()
                continue
            }
            stack.push(word[i])
        }
        if(stack.isEmpty()) {
            cnt++
        }

    }
    print(cnt)
}