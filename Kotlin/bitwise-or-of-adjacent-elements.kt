package bitwiseorofadjacentelements

// Time:  O(n)
// Space: O(1)
class Solution {
    fun orArray(nums: IntArray): IntArray {
        val result = IntArray(nums.size - 1)
        for (i in 0 until nums.size - 1) {
            result[i] = nums[i] or nums[i + 1]
        }
        return result
    }
}
