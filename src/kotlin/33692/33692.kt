fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    val binA = a.toString(2)
    val binB = b.toString(2)

    val sbA = StringBuilder(binA)//min
    val sbB = StringBuilder(binB)//max
    var flag = false
    if (binA.length < binB.length) {
        val diff = sbB.length - sbA.length
        for (i in 0 until diff) {
            if (sbB[i] == '0') {
                sbA.insert(i, '1')
            } else {
                sbA.insert(i, '0')
            }
        }
        for (i in 0 until sbA.length) {
            //이것도 max가 더 올려질 수도 있음
            if(sbA[i]=='1' && sbB[i]=='1') {
                sbB[i] = '0'
            }
            else if(sbA[i]=='0' && sbB[i]=='0') {
                sbA[i]='1'
            }
        }
    } else {
        for (i in 0 until sbA.length) {
            if (!flag && sbA[i] == sbB[i]) {
                continue
            }else if(!flag && sbB[i]!=sbA[i]) {//이 경우는 항상 sbB가 큼 그니까 이 이후에는 sbA를 올리는 방식이여야함 (sbB=1, sbA=0
                flag= true
            }
            else if(flag && sbA[i]=='0' &&sbB[i]=='0') {
                sbA[i]='1'
            }
            else if(flag && sbA[i]=='1' && sbB[i] =='1') {
                sbB[i]='0'
            }

        }
    }
    print("${sbA.toString().toLong(2)} ${sbB.toString().toLong(2)}")
}