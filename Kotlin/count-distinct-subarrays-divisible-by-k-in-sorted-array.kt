package countdistinctsubarraysdivisiblebykinsortedarray

// Time:  O(n)
// Space: O(min(n, k))

// prefix sum, freq table
class Solution {
    fun numGoodSubarrays(nums: IntArray, k: Int): Long {
        val cnt = HashMap<Int, Int>()
        cnt[0] = 1
        var result = 0L
        var prefix = 0
        var i = 0
        while (i < nums.size) {
            var j = i
            var prefix2 = prefix
            while (j < nums.size && nums[j] == nums[i]) {
                prefix2 = (prefix2 + nums[j]) % k
                result += cnt[prefix2] ?: 0
                ++j
            }
            while (i < j) {
                prefix = (prefix + nums[i]) % k
                cnt[prefix] = (cnt[prefix] ?: 0) + 1
                ++i
            }
        }
        return result
    }
}
