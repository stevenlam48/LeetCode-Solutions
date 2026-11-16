package minimumenergytomaintainbrightness

// Time:  O(nlogn)
// Space: O(1)

// sort, line sweep
class Solution {
    fun minEnergy(n: Int, brightness: Int, intervals: Array<IntArray>): Long {
        val ceilDivide = { a: Long, b: Long -> (a + b - 1) / b }

        intervals.sortWith(compareBy { it[0] })
        var result = 0L
        var left = 0
        var right = -1
        for (x in intervals) {
            if (x[0] <= right + 1) {
                right = maxOf(right, x[1])
                continue
            }
            result += (right - left + 1).toLong()
            left = x[0]
            right = x[1]
        }
        result += (right - left + 1).toLong()
        result *= ceilDivide(brightness.toLong(), 3L)
        return result
    }
}
