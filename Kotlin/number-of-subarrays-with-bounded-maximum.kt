package numberofsubarrayswithboundedmaximum
// Time:  O(n)
// Space: O(1)

class Solution {
    private fun count(values: IntArray, bound: Int): Long {
        var result = 0L
        var current = 0L
        for (value in values) {
            current = if (value <= bound) current + 1 else 0
            result += current
        }
        return result
    }

    fun numSubarrayBoundedMax(A: IntArray, L: Int, R: Int): Int {
        return (count(A, R) - count(A, L - 1)).toInt()
    }
}
