package smallestsubarrayswithmaximumbitwiseor
// Time:  O(n)
// Space: O(1)

class Solution {
    fun smallestSubarrays(nums: IntArray): IntArray {
        val bitLength = { x: Int -> if (x != 0) 32 - Integer.numberOfLeadingZeros(x) else 1 }
        val result = IntArray(nums.size)
        val lookup = IntArray(bitLength(nums.max())) { -1 }
        for (i in nums.lastIndex downTo 0) {
            for (bit in lookup.indices) {
                if (nums[i] and (1 shl bit) != 0) {
                    lookup[bit] = i
                }
            }
            result[i] = maxOf(lookup.max() - i + 1, 1)
        }
        return result
    }
}
