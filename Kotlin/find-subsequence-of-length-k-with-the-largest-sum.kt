package findsubsequenceoflengthkwiththelargestsum

// Time:  O(n)
// Space: O(n)

// quick select solution
class Solution {
    fun maxSubsequence(nums: IntArray, k: Int): IntArray {
        val partition = nums.sortedArrayDescending()
        var cnt = 0
        for (i in 0 until k) {
            if (partition[i] == partition[k - 1]) {
                ++cnt
            }
        }
        val result = mutableListOf<Int>()
        for (i in nums.indices) {
            if (nums[i] > partition[k - 1] || (nums[i] == partition[k - 1] && --cnt >= 0)) {
                result.add(nums[i])
            }
        }
        return result.toIntArray()
    }
}
