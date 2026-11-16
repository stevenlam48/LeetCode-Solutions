package countsubarrayswithmajorityelementii
// Time:  O(n)
// Space: O(n)

class Solution {
    fun countMajoritySubarrays(nums: IntArray, target: Int): Long {
        val cnt = LongArray((2 * nums.size + 1) + 1)
        val prefix = LongArray((2 * nums.size + 1) + 1)
        prefix[nums.size + 1] = 1
        cnt[nums.size + 1] = 1
        var result = 0L
        var curr = nums.size + 1
        for (x in nums) {
            curr += if (x == target) 1 else -1
            ++cnt[curr]
            prefix[curr] = prefix[curr - 1] + cnt[curr]
            result += prefix[curr - 1]
        }
        return result
    }
}
