package maximizesubarraysumafterremovingalloccurrencesofoneelement

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxSubarraySum(nums: IntArray): Long {
        var result = Long.MIN_VALUE
        var curr = 0L
        var mn = 0L
        var mn0 = 0L
        val mn1 = HashMap<Int, Long>()
        for (x in nums) {
            curr += x
            result = maxOf(result, curr - mn)
            mn1[x] = minOf(mn1[x] ?: 0L, mn0) + x
            mn0 = minOf(mn0, curr)
            mn = minOf(mn, mn1[x]!!, mn0)
        }
        return result
    }
}
