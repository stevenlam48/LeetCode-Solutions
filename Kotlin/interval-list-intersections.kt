package intervallistintersections

// Time:  O(m + n)
// Space: O(1)

class Interval(var start: Int = 0, var end: Int = 0)

class Solution {
    fun intervalIntersection(A: Array<Interval>, B: Array<Interval>): List<Interval> {
        val result = mutableListOf<Interval>()
        var i = 0
        var j = 0
        while (i < A.size && j < B.size) {
            val left = maxOf(A[i].start, B[j].start)
            val right = minOf(A[i].end, B[j].end)
            if (left <= right) {
                result.add(Interval(left, right))
            }
            if (A[i].end < B[j].end) {
                ++i
            } else {
                ++j
            }
        }
        return result
    }
}
