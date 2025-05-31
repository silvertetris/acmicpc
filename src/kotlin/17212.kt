package kotlin

fun main() {
    var input = readln().toInt()
    var result =0

    while(input!=0) {
        if(input<=10 && input%5 ==0) {
            result+=input/5
            input=0
            break
        }
        input-=7
        result ++

        if(input<0) {
            input+=7
            result--
            break
        }
    }
    if(input ==0) {
        print(result)
    }
    else if( input == 1||input ==2||input==5) {
        print(result+1)
    }
    else{
        print(result+2)
    }
}