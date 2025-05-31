package kotlin

fun main() {
    var arr:Array<Int> = readln().split(" ").map{it.toInt()}.toTypedArray()
    arr.sortDescending()
    var games:Int=0
    var score:Int=0
    var winOrLose:Array<Int> = Array<Int>(3) {0}
    var win =0
    var tie = 0
    var lose = 0
    for( i in 1..4) {
        if(arr[0] == arr[1]+arr[2]+arr[3]+arr[4]-arr[i]) {
            //arr[i] 하고 arr[0]제외하고 넣어야함.
            games=arr[0]
            score=arr[i]
            var temp =0
            var temp2 =1
            while(temp!=3) {
                if(temp2!=i) {
                    winOrLose[temp] = arr[temp2]
                    temp++
                    temp2++
                }
                else{
                    temp2++
                }
            }
            break
        }
    }
    if(arr[1]==arr[2]+arr[3]+arr[4]) {
        games=arr[1]
        score=arr[0]
        winOrLose[0] = arr[2]
        winOrLose[1] = arr[3]
        winOrLose[2] = arr[4]
    }
    if(winOrLose[0]*3 + winOrLose[1]== score) {
        win = winOrLose[0]
        tie = winOrLose[1]
        lose = winOrLose[2]
    }
    else if(winOrLose[0]*3 + winOrLose[2] == score) {
        win = winOrLose[0]
        tie = winOrLose[2]
        lose = winOrLose[1]
    }
    else if(winOrLose[1]*3 + winOrLose[0] == score) {
        win = winOrLose[1]
        tie = winOrLose[0]
        lose = winOrLose[2]
    }
    else if(winOrLose[1]*3 + winOrLose[2] == score) {
        win = winOrLose[1]
        tie = winOrLose[2]
        lose = winOrLose[0]
    }
    else if(winOrLose[2]*3 + winOrLose[0] == score) {
        win = winOrLose[2]
        tie = winOrLose[0]
        lose = winOrLose[1]
    }
    else if(winOrLose[2]*3 + winOrLose[1] == score) {
        win = winOrLose[2]
        tie = winOrLose[1]
        lose = winOrLose[0]
    }
    print("$games $win $tie $lose $score")
}