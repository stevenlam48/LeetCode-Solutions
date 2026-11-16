package countnumberofbadpairs

// Time:  O(n)
// Space: O(n)

// freq table
class Solution {
    fun countBadPairs(nums: IntArray): Long {
        var result = nums.size.toLong() * (nums.size - 1) / 2
        val cnt = HashMap<Int, Int>()
        for (i in nums.indices) {
            val key = nums[i] - i
            val v = cnt.getOrDefault(key, 0)
            result -= v
            cnt[key] = v + 1
        }
        return result
    }
}
