package longestsubsequencewithnonzerobitwisexor
// Time:  O(n)
// Space: O(1)

class Solution {
    fun longestSubsequence(nums: IntArray): Int {
        if (nums.all { it == 0 }) {
            return 0
        }
        val xor = nums.fold(0) { accumulator, x -> accumulator xor x }
        return nums.size - if (xor == 0) 1 else 0
    }
}
