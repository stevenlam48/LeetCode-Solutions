package arraynesting

// Time:  O(n)
// Space: O(1)

class Solution {
    fun arrayNesting(nums: IntArray): Int {
        var result = 0
        for (num in nums) {
            if (num != Int.MAX_VALUE) {
                var start = num
                var count = 0
                while (nums[start] != Int.MAX_VALUE) {
                    val temp = start
                    start = nums[start]
                    nums[temp] = Int.MAX_VALUE
                    ++count
                }
                result = maxOf(result, count)
            }
        }
        return result
    }
}
