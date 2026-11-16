package countsubarrayswithmajorityelementi

// Time:  O(n)
// Space: O(n)

// prefix sum, freq table
class Solution {
    fun countMajoritySubarrays(nums: IntArray, target: Int): Int {
        val cnt = IntArray(2 * nums.size + 2)
        val prefix = IntArray(2 * nums.size + 2)
        prefix[nums.size + 1] = 1
        cnt[nums.size + 1] = 1
        var result = 0
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
