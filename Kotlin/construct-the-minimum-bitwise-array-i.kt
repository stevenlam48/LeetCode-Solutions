package constructtheminimumbitwisearrayi

// Time:  O(n)
// Space: O(1)

// bit manipulation
class Solution {
    fun minBitwiseArray(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { -1 }
        for (i in nums.indices) {
            if ((nums[i] and 1) != 0) {
                result[i] = nums[i] - (((nums[i] + 1) and nums[i].inv()) shr 1)
            }
        }
        return result
    }
}
