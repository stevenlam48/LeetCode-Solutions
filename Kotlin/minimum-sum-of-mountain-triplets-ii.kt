package minimumsumofmountaintripletsii

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minimumSum(nums: IntArray): Int {
        val inf = Int.MAX_VALUE
        val right = IntArray(nums.size) { inf }
        var curr = inf
        for (i in nums.size - 1 downTo 0) {
            right[i] = curr
            curr = minOf(curr, nums[i])
        }
        var result = inf
        curr = inf
        for (i in nums.indices) {
            if (curr < nums[i] && nums[i] > right[i]) {
                result = minOf(result, curr + nums[i] + right[i])
            }
            curr = minOf(curr, nums[i])
        }
        return if (result != inf) result else -1
    }
}
