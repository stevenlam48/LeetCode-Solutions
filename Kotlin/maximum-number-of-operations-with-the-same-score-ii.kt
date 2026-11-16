package maximumnumberofoperationswiththesamescoreii

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun maxOperations(nums: IntArray): Int {
        fun memoization(left: Int, right: Int, target: Int, lookup: Array<IntArray>): Int {
            if (!(right - left + 1 >= 2)) {
                return 0
            }
            if (lookup[left][right] == -1) {
                var best = 0
                if (nums[left] + nums[left + 1] == target) {
                    best = maxOf(best, 1 + memoization(left + 2, right, target, lookup))
                }
                if (nums[left] + nums[right] == target) {
                    best = maxOf(best, 1 + memoization(left + 1, right - 1, target, lookup))
                }
                if (nums[right - 1] + nums[right] == target) {
                    best = maxOf(best, 1 + memoization(left, right - 2, target, lookup))
                }
                lookup[left][right] = best
            }
            return lookup[left][right]
        }

        var result = 0
        for (target in hashSetOf(nums[0] + nums[1], nums[0] + nums[nums.size - 1], nums[nums.size - 2] + nums[nums.size - 1])) {
            val lookup = Array(nums.size) { IntArray(nums.size) { -1 } }
            result = maxOf(result, memoization(0, nums.size - 1, target, lookup))
        }
        return result
    }
}
