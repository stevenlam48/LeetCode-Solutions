package reverseksubarrays

// Time:  O(n)
// Space: O(1)

class Solution {
    fun reverseSubarrays(nums: IntArray, k: Int): IntArray {
        fun reverse(left0: Int, right0: Int) {
            var left = left0
            var right = right0
            while (left < right) {
                val tmp = nums[left]
                nums[left] = nums[right]
                nums[right] = tmp
                ++left
                --right
            }
        }

        val l = nums.size / k
        if (l == 0) {
            return nums
        }
        var i = 0
        while (i < nums.size) {
            reverse(i, minOf(i + l - 1, nums.size - 1))
            i += l
        }
        return nums
    }
}
