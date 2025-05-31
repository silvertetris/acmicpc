package kotlin

fun main() {
    val n = readLine()!!.toInt()
    val result:Array<String> = Array<String>(n) {""}
    val pattern = readln()
    val arr:Array<String> = Array<String>(n) {""}
    for(i in 0 until n) {
        arr[i]= readln()
        if(arr[i].length<pattern.length-1) {
            result[i]="NE"
            continue
        }
        var cnt =0
        var temp =0
        for(j in 0 until arr[i].length-1) {
            if(arr[i][j]==pattern[temp]) {
                temp++
                continue
            }
            else if(arr[i][j]!=pattern[temp]&&pattern[temp]=='*') {
                temp=pattern.length-1
                break
            }
            else {
                result[i] = "NE"
                cnt =1
                break
            }
        }
        if(cnt==1) {
            continue
        }
        for(j in arr[i].length-1 downTo 1) {
            if(arr[i][j]==pattern[temp]) {
                temp--
                continue
            }
            else if(arr[i][j]!=pattern[temp]&&pattern[temp]=='*') {
                 break
            }
            else {
                result[i]="NE"
                cnt=1
                break
            }
        }
        if(cnt==0) {
            result[i] = "DA"
        }
    }
    for (i in result.indices) {
        println(result[i])
    }
}