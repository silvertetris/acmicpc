fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = IntArray(60 * 60 * 24 + 1) { 0 }
    val tree = LongArray(60 * 60 * 24 * 4 + 1) { 0 }
    fun change(s: String): Pair<Int, Int> {
        val line = s.split(" - ")
        val start = line[0].split(":").map { it.toInt() }
        val end = line[1].split(":").map { it.toInt() }
        return start[0] * 3600 + start[1] * 60 + start[2] to end[0] * 3600 + end[1] * 60 + end[2]
    }
    repeat(n) {
        val s = br.readLine()
        val (start, end) = change(s)
        if (end >= start) {
            for (i in start..end) {
                arr[i]++
            }
        } else {
            for (i in start..86400) {
                arr[i]++
            }
            for (i in 0..end) {
                arr[i]++
            }
        }
    }
    fun treeInit(left: Int, right: Int, node: Int) {
        if (left == right) {
            tree[node] = arr[left].toLong()
            return
        }
        val mid = (left + right) / 2
        treeInit(left, mid, node * 2)
        treeInit(mid + 1, right, node * 2 + 1)
        tree[node] = tree[node * 2] + tree[node * 2 + 1]
    }
    treeInit(0, 60 * 60 * 24, 1)
    fun sum(node: Int, left: Int, right: Int, ql: Int, qr: Int): Long {
        if (qr < left || right < ql) return 0
        if (ql <= left && right <= qr) return tree[node]
        val mid = (left + right) / 2
        return sum(node * 2, left, mid, ql, qr) +
                sum(node * 2 + 1, mid + 1, right, ql, qr)
    }

    val q = br.readLine().toInt()
    repeat(q) {
        val s = br.readLine()
        val (start, end) = change(s)
        if (end >= start) {
            bw.write("${sum(1, 0, 60 * 60 * 24, start, end).toDouble() / (end - start + 1)}\n")
        } else {
            bw.write(
                "${
                    (sum(1, 0, 60 * 60 * 24, start, 86399) + sum(
                        1,
                        0,
                        60 * 60 * 24,
                        0,
                        end
                    )).toDouble() / (86400 - start + end + 1)
                }\n"
            )
        }
    }
    bw.flush()
    bw.close()
}