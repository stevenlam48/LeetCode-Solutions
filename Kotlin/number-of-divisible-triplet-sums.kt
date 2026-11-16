package numberofdivisibletripletsums

// Time:  O(n^2)
// Space: O(n)

// freq table
class Solution {
    fun divisibleTripletCount(nums: IntArray, d: Int): Int {
        var result = 0
        val cnt = HashMap<Int, Int>()
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val key = (nums[i] + nums[j]) % d
                cnt[key]?.let { result += it }
            }
            val key = ((-nums[i]) % d + d) % d
            cnt[key] = (cnt[key] ?: 0) + 1
        }
        return result
    }
}
