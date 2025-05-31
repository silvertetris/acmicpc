package kotlin

fun main() {
    var toTypedArray = readln().split(" ").map { it.toInt() }.toTypedArray()
    val p3 = toTypedArray[0]
    val p4 = toTypedArray[1]
    var p0 = toTypedArray[2]
    var triple = 0
    var quad = 0

    triple += p3 / 3
    quad += p4 / 4
    var tripleRemain = p3 % 3
    var quadRemain = p4 % 4
    if(tripleRemain != 0) {
        triple++
        p0 = p0 - 3 +tripleRemain
    }
    if(quadRemain != 0) {
        quad++
        p0 = p0 -4 +quadRemain
    }
    if(p0<0||p0==1 || p0 ==2 ||p0==5) {
        print(-1)
        return
    }
    while(p0!=0) {
        p0-=4
        quad++
        if(p0<0) {
            quad--
            p0+=1
            triple++
        }
        else if(p0==3) {
            triple++
            break
        }
        else if(p0==2) {
            triple+=2
            quad-=1
            break
        }
        else if(p0==1) {
            triple+=3
            quad-=2
            break
        }
    }

    print("$triple $quad")
}