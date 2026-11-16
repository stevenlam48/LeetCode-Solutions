package createtargetarrayinthegivenorder

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
        for (i in nums.indices) {
            for (j in 0 until i) {
                if (index[j] >= index[i]) {
                    ++index[j]
                }
            }
        }
        val result = IntArray(nums.size)
        for (i in nums.indices) {
            result[index[i]] = nums[i]
        }
        return result
    }
}
