package maximumsubarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var result = Int.MIN_VALUE
        var curr = Int.MIN_VALUE
        for (x in nums) {
            curr = if (curr == Int.MIN_VALUE) x else maxOf(curr + x, x)
            result = maxOf(result, curr)
        }
        return result
    }
}
