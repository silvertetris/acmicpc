import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val coor = br.readLine().split(" ").map{it.toInt()}.toIntArray()
    var s = 1
    for(i in 0 until 11) {
        s*=coor[i]
    }
    val arr = IntArray(s+1)
    var idxCnt = 0
    for(i in 0 until s/coor[10]) {
        val str = StringTokenizer(br.readLine())
        for(j in 0 until coor[10]) {
            arr[idxCnt] = str.nextToken().toInt()
            idxCnt++
        }
    }

    val mul = IntArray(11)//11차원 -> 1차원 시에 각 인덱스의 한계지점 (w시에는 1칸, v시에는 w칸 만큼 점프)
    var tempMul = s
    for(i in 0 until 11) {//상위 -> 하위
        tempMul/=coor[i]
        mul[i] = tempMul
    }

    val init = arr[0]

    var flag = true
    for(i in 0 until s) {
        var tempI = i
        var sum=0
        for(j in 0 until 11) {
            val c = (tempI/mul[j])
            sum+=c
            tempI%=mul[j]
        }
        val diff= if(sum%2==init) 0 else 1
        if(arr[i]!=diff) {
            flag = false
            break
        }
    }
    if(flag) {
        print("Yes")
    } else {
        print("No")
    }
}