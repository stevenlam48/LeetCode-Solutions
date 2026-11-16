package minimumarraylengthafterpairremovals

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minLengthAfterRemovals(nums: IntArray): Int {
        val counts = HashMap<Int, Int>()
        for (x in nums) {
            counts[x] = (counts[x] ?: 0) + 1
        }
        var maximum = 0
        for (count in counts.values) {
            maximum = maxOf(maximum, count)
        }
        return if (maximum > nums.size - maximum) maximum - (nums.size - maximum) else nums.size % 2
    }
}
