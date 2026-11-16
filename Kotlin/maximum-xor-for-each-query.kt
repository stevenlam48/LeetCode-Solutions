package maximumxorforeachquery

// Time:  O(n)
// Space: O(1)

class Solution {
    fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
        val result = IntArray(nums.size)
        var mask = (1 shl maximumBit) - 1
        for (i in nums.indices) {
            mask = mask xor nums[i]
            result[nums.size - 1 - i] = mask
        }
        return result
    }
}
