fun main() {
    val bw = System.out.bufferedWriter()
    var n = readln().toLong()
    val str = StringBuilder()
    if(n==1L) {
        bw.write("4\n")
        bw.write("[+] [*] [-] [/]")
        bw.flush()
        bw.close()
        return
    }
    var cnt = 0
    while(true) {
        val cur = n.toString(2)
        if(cur=="11") {
            cnt+=3
            str.append("+/+")
            break
        }
        if(cur=="10") {
            cnt++
            str.append("+")
            break
        }
        else {
            var a = cur[cur.lastIndex]
            var b = cur[cur.lastIndex-1]
            var check = "$b$a"
            if(check =="11") {
                cnt+=5
                str.append("/+*+*")
                n = n shr 1
                n--
            }else if(check =="10") {
                cnt+=2
                str.append("+*")
                n = n shr 1
                n--
            }
            else if(check == "00") {
                cnt++
                str.append("*")
                n = n shr 1
            }
            else {//01
                cnt+=4
                str.append("/+**")
                n= n shr 1
            }
        }
    }
    if(cnt>99) {
        bw.write("-1")
    } else {
        bw.write("$cnt\n")
        for(i in str.lastIndex downTo 0) {
            bw.write("[${str[i]}] ")
        }
    }
    bw.flush()
    bw.close()
}