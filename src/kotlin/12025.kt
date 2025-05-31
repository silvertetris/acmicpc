package kotlin

fun main() {
    var num = readln()
    var str = ""
    val index = readln().toInt()
    for(i in num.indices) {
        if(num[i]=='6')
            str+='1'
        else if(num[i]=='7')
            str+='2'
        else {
            str+=num[i]
        }
    }
    var charStr:CharArray = str.toCharArray()
    var temp=0
    while(true) {
        if(temp==index-1){
            break
        }
        for(i in str.length-1 downTo 0) {

            if(str[i]=='1'){
                charStr[i]='6'
                for(j in str.length-1 downTo  i+1){
                    if(charStr[i]=='7')
                        charStr[j]='2'
                    else if(charStr[j]=='6')
                        charStr[j]='1'
                }
                temp++
                break
            }
            else if(str[i]=='2') {
                charStr[i]='7'
                for(j in str.length-1 downTo  i+1){
                    if(charStr[j]=='6'){
                        charStr[j]='1'
                    }
                    else if(charStr[j]=='7')
                        charStr[j]='2'
                }
                temp++
                break
            }
            else continue
        }
    }

    print(charStr.joinToString(""))
}