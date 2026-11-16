package maxvalueofequation

// Time:  O(n)
// Space: O(n)

class Solution {
    fun findMaxValueOfEquation(points: Array<IntArray>, k: Int): Int {
        var result = Int.MIN_VALUE
        val dq = ArrayDeque<Int>()
        for (i in points.indices) {
            val x = points[i][0]
            val y = points[i][1]
            while (dq.isNotEmpty() && points[dq.first()][0] < x - k) {
                dq.removeFirst()
            }
            if (dq.isNotEmpty()) {
                result = maxOf(result, points[dq.first()][1] - points[dq.first()][0] + y + x)
            }
            while (dq.isNotEmpty() && points[dq.last()][1] - points[dq.last()][0] <= y - x) {
                dq.removeLast()
            }
            dq.addLast(i)
        }
        return result
    }
}
