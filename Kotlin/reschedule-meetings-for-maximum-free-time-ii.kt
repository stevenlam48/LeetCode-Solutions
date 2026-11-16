package reschedulemeetingsformaximumfreetimeii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxFreeTime(eventTime: Int, startTime: IntArray, endTime: IntArray): Int {
        fun topk(start: List<Int>, end: List<Int>, k: Int): List<IntArray> {
            val topk = MutableList(k) { intArrayOf(Int.MIN_VALUE, Int.MIN_VALUE) }
            for (i in start.indices) {
                val x = intArrayOf(start[i] - end[i], end[i])
                for (y in topk) {
                    if (x[0] > y[0] || (x[0] == y[0] && x[1] > y[1])) {
                        val tx = x[0]
                        val ty = x[1]
                        x[0] = y[0]
                        x[1] = y[1]
                        y[0] = tx
                        y[1] = ty
                    }
                }
            }
            return topk
        }

        val start = startTime.toMutableList().apply { add(eventTime) }
        val end = endTime.toMutableList().apply { add(0, 0) }
        val top3 = topk(start, end, 3)
        var result = 0
        var i = 0
        while (i + 1 < start.size) {
            var l = 0
            for (p in top3) {
                val mx = p[0]
                val e = p[1]
                if (e != end[i] && e != end[i + 1] && end[i + 1] - start[i] <= mx) {
                    l = end[i + 1] - start[i]
                    break
                }
            }
            result = maxOf(result, (start[i] - end[i]) + (start[i + 1] - end[i + 1]) + l)
            ++i
        }
        return result
    }
}
