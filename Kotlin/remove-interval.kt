package removeinterval

// Time:  O(n)
// Space: O(1)
class Solution {
    fun removeInterval(intervals: Array<IntArray>, toBeRemoved: IntArray): Array<IntArray> {
        val result = ArrayList<IntArray>()
        for (interval in intervals) {
            val tmp = arrayOf(
                intArrayOf(interval[0], minOf(toBeRemoved[0], interval[1])),
                intArrayOf(maxOf(interval[0], toBeRemoved[1]), interval[1])
            )
            for (p in tmp) {
                if (p[0] < p[1]) {
                    result.add(p)
                }
            }
        }
        return result.toTypedArray()
    }
}
