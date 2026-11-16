package longeststrictlyincreasingorstrictlydecreasingsubarray
// Time:  O(n)
// Space: O(1)

class Solution {
    fun longestMonotonicSubarray(nums: IntArray): Int {
        fun compare(x: Int, y: Int): Int {
            return if (x < y) -1 else if (x > y) 1 else 0
        }

        var result = if (nums.size == 1 || compare(nums[0], nums[1]) == 0) 1 else 2
        var count = result
        for (i in 2 until nums.size) {
            count = if (compare(nums[i - 1], nums[i]) == 0) {
                1
            } else if (compare(nums[i - 2], nums[i - 1]) == compare(nums[i - 1], nums[i])) {
                count + 1
            } else {
                2
            }
            result = maxOf(result, count)
        }
        return result
    }
}
