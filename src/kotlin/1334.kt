

fun main() {
    val n = readln()
    if(n=="9") {
        print(11)
        return
    }
    if (n.length % 2 == 0) {
        var front = ""
        var back = ""
        for (i in 0 until n.length / 2) {
            front += n[i]
        }
        for (i in n.length / 2 until n.length) {
            back += n[i]
        }
        if (front.reversed() <= back) {
            var secFront = ""
            var carry =1
            for(i in front.length-1 downTo 0) {
                var temp = front[i]-'0' +carry
                secFront+=(temp%10).toString()
                carry = temp/10
                if(i==0 && carry==1) {
                    secFront+=carry.toString()
                }
            }
            front=secFront.reversed()
            back = front.reversed()
            var result = front + back
            if (n.length != result.length) {
                result = front.dropLast(1) + back
            }
            print(result)
        } else {
            print(front + front.reversed())
        }
    } else {
        var front = ""
        var middle = n[n.length / 2] - '0'
        var back = ""
        for (i in 0 until n.length / 2) {
            front += n[i]
        }
        for (i in n.length / 2 + 1 until n.length) {
            back += n[i]
        }
        if (front.reversed() <= back) {
            middle++
            if (middle == 10) {
                var secFront = ""
                var carry =1
                for(i in front.length-1 downTo 0) {
                    var temp = front[i]-'0' +carry
                    secFront+=(temp%10).toString()
                    carry = temp/10
                    if(i==0 && carry==1) {
                        secFront+=carry.toString()
                    }
                }
                front=secFront.reversed()
                middle = 0
            }
            back = front.reversed()
            var result = front + middle.toString() + back
            if (n.length != result.length) {
                result = front + back
            }
            print(result)
        } else {
            print(front + middle.toString() + front.reversed())
        }

    }
}